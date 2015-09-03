package com.redrock.date2.moudel.launch;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.redrock.date2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.smssdk.gui.TimeListener;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(VerifyPresenter.class)
public class VerifyActivity extends BeamBaseActivity<VerifyPresenter> implements TimeListener {

    @InjectView(R.id.re_code)
    Button reCode;
    @InjectView(R.id.send)
    Button send;
    @InjectView(R.id.code)
    EditText code;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.re_password)
    EditText rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity_verify);
        ButterKnife.inject(this);
        send.setOnClickListener(v->checkInput());
        reCode.setOnClickListener(v -> getPresenter().reSendMessage());
    }

    public void checkInput() {
        if (code.getText().toString().isEmpty()){
            JUtils.Toast("请输入验证码");
            return;
        }
        if (password.getText().toString().length()<6||password.getText().toString().length()>12){
            JUtils.Toast("请输6-12位密码");
            return;
        }
        if (!rePassword.getText().toString().equals(password.getText().toString())){
            JUtils.Toast("两次密码不一致");
            return;
        }
        getPresenter().send(code.getText().toString(),password.getText().toString());
    }

    @Override
    public void onLastTimeNotify(int lastSecond) {
        if (lastSecond>0)
            reCode.setText(lastSecond + "秒后重新发送");
        else
            reCode.setText("重新发送");
    }

    @Override
    public void onAbleNotify(boolean valuable) {
        reCode.setEnabled(valuable);
    }
}
