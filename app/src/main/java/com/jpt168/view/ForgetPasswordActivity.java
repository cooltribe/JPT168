package com.jpt168.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jpt168.R;

/**
 * Created by caomingyu on 15/9/22.
 * email:361786231@qq.com
 */
public class ForgetPasswordActivity extends Activity {
    TextView titleTx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        titleTx = (TextView) findViewById(R.id.title_tx);
        titleTx.setText(getResources().getString(R.string.forget_password));
    }
}
