package com.redrock.date2.moudel.launch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.model.bean.Account;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginPresenter> {

    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.register)
    TextView register;
    @InjectView(R.id.find_password)
    TextView findPassword;
    @InjectView(R.id.phone)
    EditText phone;
    @InjectView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity_login);
        ButterKnife.inject(this);
        register.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        login.setOnClickListener(v -> checkInput());
    }

    public void setAccount(Account account){
        phone.setText(account.getNumber());
        password.setText(account.getPassword());
    }

    public void checkInput(){
        if (phone.getText().length()!=11){
            JUtils.Toast("请输入正确手机号");
            return;
        }
        if (password.getText().length()<6||password.getText().length()>12){
            JUtils.Toast("请输入正确密码");
            return;
        }
        getPresenter().login(phone.getText().toString(),password.getText().toString());
    }
}
