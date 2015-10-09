package com.jpt168.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jpt168.R;

/**
 * Created by caomingyu on 15/9/22.
 * email:361786231@qq.com
 */
public class LoginActivity extends Activity {
    TextView forgetPasswordTx;
    PersonCenterItemView myOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


//        setContentView(R.layout.usercenter);
        forgetPasswordTx = (TextView) findViewById(R.id.forget_password_tx);
        forgetPasswordTx.setOnClickListener(new loginClickListener());
        myOrder = (PersonCenterItemView) findViewById(R.id.my_order);
//        myOrder.setLeftText(R.drawable.mail_icon,"我的订单");
    }
    private final class loginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.forget_password_tx:
                    Intent intent = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
