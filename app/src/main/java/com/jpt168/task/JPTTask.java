package com.jpt168.task;


import android.content.Context;
import android.text.TextUtils;

import com.jpt168.application.LogManager;
import com.jpt168.widget.JPTDialogFactory;

import java.util.Iterator;
import java.util.LinkedList;
import com.jpt168.R;

/**
 * Created by caomingyu on 15-9-5.
 */
public abstract class JPTTask<Result> extends BaseTask<Result> {
    Context  context;
    String tipMsg ;
    boolean cancelable ,showDialog ;
    JPTDialogFactory dialog;
    Exception mException;

    public JPTTask(Context context) {
        this(context,context.getString(R.string.loading_tips));
    }
    public JPTTask(Context context, Object... obj) {
        this(context,context.getString(R.string.loading_tips),true);
    }
    public JPTTask(Context context, String tipMsg, boolean cancelable) {
        this.context  = context;
        this.tipMsg  = tipMsg;
        this.cancelable = cancelable;
    }



    private LinkedList<OnTaskFinishedListener<Result>> mOnTaskFinishedListeners;
    public static interface OnTaskFinishedListener<Result> {
        public void onTaskFinish(Result result, JPTTask task, Exception exception);
    }
    public void addOnTaskFinishedListener(OnTaskFinishedListener<Result> listener) {
        if (mOnTaskFinishedListeners == null) {
            mOnTaskFinishedListeners = new LinkedList<OnTaskFinishedListener<Result>>();
        }
        mOnTaskFinishedListeners.add(listener);
    }

    private LinkedList<OnTaskLoadingListener<Result>> mOnTaskLoadingListeners;
    public static interface OnTaskLoadingListener<Result> {
        public void onTaskLoading(Result result, JPTTask task, Exception exception);
    }
    public void addOnTaskLoadingListener(OnTaskLoadingListener<Result> listener) {
        if (mOnTaskLoadingListeners == null) {
            mOnTaskLoadingListeners = new LinkedList<OnTaskLoadingListener<Result>>();
        }
        mOnTaskLoadingListeners.add(listener);
    }
    @Override
    protected void onCancelled() {
        super.onCancelled();

    }
    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

    @Override
    protected void onPreExecute() {
    //TODO dialog is show
        if (showDialog) {
            if (dialog == null) {
                dialog = new JPTDialogFactory(context,this,cancelable);
            }
            try {
                dialog.setCancelable(showDialog);
                if (!TextUtils.isEmpty(tipMsg)) {
                    dialog.setMessage(tipMsg);
                }
                if (!dialog.isShowing()) {
                    dialog.show();
                }
            } catch (Exception e) {
            }
        }


    }

    @Override
    protected Result doInBackground() {
        Result _result = null;
        try {
            _result = onTaskLoading();
        } catch (Exception e) {
            mException = e;
            e.printStackTrace();
            LogManager.e("JPTTask", "======doInBackground error====\n" + e.getMessage().toString());
        }
        if (mOnTaskLoadingListeners != null) {
            Iterator<OnTaskLoadingListener<Result>> iterator = mOnTaskLoadingListeners.iterator();
            while (iterator.hasNext()) {
                OnTaskLoadingListener listener = iterator.next();
                listener.onTaskLoading(_result, this, mException);
                iterator.remove();
            }
        }

        return _result;
    }

    @Override
    protected void onPostExecute(Result result) {
        if (this.isCancelled() || context == null) {
            return;
        }
        try {
            if (mOnTaskFinishedListeners != null) {
                Iterator<OnTaskFinishedListener<Result>> iterator = mOnTaskFinishedListeners.iterator();
                while (iterator.hasNext()) {
                    OnTaskFinishedListener listener = iterator.next();
                    listener.onTaskFinish(result, this, mException);
                    LogManager.e("AsyncDialog", "dialog-->" + dialog);
                    dialog.dismiss();
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
                LogManager.e("AsyncDialog", e.toString());

        } finally {
            context = null;
        }

    }

    protected abstract Result onTaskLoading() throws Exception;


}



