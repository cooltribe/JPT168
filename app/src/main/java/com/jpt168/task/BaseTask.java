package com.jpt168.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by caomingyu on 15-3-10.
 */
public abstract class BaseTask<Result> implements Task<Result>{
    private static final String TAG = "BaseTask";
    private final Callable<Result> mWorker;
    private final FutureTask<Result> mFuture;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    private static final int MESSAGE_PRETASK = 0;
    private static final int MESSAGE_POST_RESULT = 1;
    private static Handler sHandler;

    public static final int STATUS_PENDING = 0;
    public static final int STATUS_RUNNING = 1;
    public static final int STATUS_FINISH = 2;
    private int status = STATUS_PENDING;

    private BaseTask preTask;  //多个task组合时的上一个任务
    private Result _result;

    private int taskMode = MODE_ASYNC;

    AtomicBoolean preExecuted = new AtomicBoolean();


    public BaseTask() {
        if (sHandler == null) {
            sHandler = new InternalHandler(Looper.getMainLooper());
        }
        mWorker = new Callable<Result>() {
            public Result call() throws Exception {
                preExecuted.set(false);
                Message message = sHandler.obtainMessage(MESSAGE_PRETASK, BaseTask.this);
                message.sendToTarget();
                mTaskInvoked.set(true);
                status = STATUS_RUNNING;

                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                while (!preExecuted.get()) {
                }
                return postResult(doTask());
            }
        };

        mFuture = new FutureTask<Result>(mWorker) {
            @Override
            protected void done() {
                try {
                    final Result result = get();

                    postResultIfNotInvoked(result);
                } catch (InterruptedException e) {
                    Log.e(TAG, e.toString());
                } catch (ExecutionException e) {
                    throw new RuntimeException(
                            "An error occured while executing doTask()",
                            e.getCause());
                } catch (CancellationException e) {
                    postResultIfNotInvoked(null);
                } catch (Throwable t) {
                    throw new RuntimeException(
                            "An error occured while executing "
                                    + "doInBackground()", t);
                }
            }
        };
    }

    @Override
    public Result doTask() {
        Result res = doInBackground();
        setResult(res);
        return res;
    }

    protected void onPreExecuteFinish() {
        preExecuted.set(true);
    }

    protected abstract void onPreExecute();

    protected abstract Result doInBackground();

    protected abstract void onPostExecute(Result res);

    protected void onCancelled() {

    }

    private void finish(Result result) {
        if (isCancelled()) {
            onCancelled();
        } else {
            onPostExecute(result);
        }
        status = STATUS_FINISH;
    }

    private void postResultIfNotInvoked(Result result) {
        final boolean wasTaskInvoked = mTaskInvoked.get();
        if (!wasTaskInvoked) {
            postResult(result);
        }
    }

    private Result postResult(Result result) {
        _result = result;
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new TaskResult<Result>(this, result));
        message.sendToTarget();
        return result;
    }

    @Override
    public int taskMode() {
        return taskMode;
    }

    public void setTaskMode(int taskMode) {
        this.taskMode = taskMode;
    }

    @Override
    public void cancel() {
        mFuture.cancel(true);
    }

    @Override
    public boolean isCancelled() {
        return mFuture.isCancelled();
    }

    @Override
    public void run() {
        mFuture.run();
    }

    public Result getResult() {
        return _result;
    }

    public void setResult(Result result) {
        this._result = result;
    }

    public BaseTask getPreTask() {
        return preTask;
    }

    public void setPreTask(BaseTask preTask) {
        this.preTask = preTask;
    }

    protected Object getPreResult(Class objclass) {
        BaseTask task;
        BaseTask curTask = this;
        if ((task = curTask.getPreTask()) != null) {
            if (task.getResult() != null && TextUtils.equals(task.getResult().getClass().getName(), objclass.getName())) {
                return task.getResult();
            }
            curTask = task;
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    private static class TaskResult<Data> {
        final BaseTask mTask;
        final Data mData;

        TaskResult(BaseTask task, Data data) {
            mTask = task;
            mData = data;
        }
    }

    private static class InternalHandler extends Handler {
        public InternalHandler(Looper mainLooper) {
            super(mainLooper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_POST_RESULT: {
                    TaskResult result = (TaskResult) msg.obj;
                    result.mTask.finish(result.mData);
                    break;
                }
                case MESSAGE_PRETASK: {
                    BaseTask task = (BaseTask) msg.obj;
                    task.onPreExecute();
                    task.onPreExecuteFinish();
                    break;
                }
            }
        }
    }  }


