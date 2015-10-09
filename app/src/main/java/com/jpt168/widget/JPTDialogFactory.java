package com.jpt168.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.jpt168.task.JPTTask;
import com.jpt168.R;


/**
 * Created by caomingyu
 */
public class JPTDialogFactory extends Dialog implements View.OnClickListener {
    boolean cancelable;
    Context context;
    private String message;

    public JPTDialogFactory(Context context, JPTTask task, boolean cancelable) {
        super(context, R.style.customDialog);
        this.cancelable = cancelable;
        this.context = context;
        this.task = task;
        this.getWindow().setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(false);
    }

    TextView messageView;
    View progressDialogClose;
    private JPTTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customprogressdialog);
        progressDialogClose = findViewById(R.id.progressDialogClose);
        messageView = (TextView) findViewById(R.id.progressContent);
        messageView.setText(message);

        progressDialogClose.setOnClickListener(this);
        if (cancelable) {
            progressDialogClose.setVisibility(View.VISIBLE);
        } else {
            progressDialogClose.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(cancelable );

    }

    @Override
    public void show() {
        super.show();
        try {
            if (task != null) {
                this.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        // 取消任务
                        if (task != null) {
                            try {
                                task.cancel();
                            } catch (Exception e) {
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.progressDialogClose: {
                dismiss();
                break;
            }
        }
    }


    public void setMessage(String message) {
        this.message  = message;
    }
}
