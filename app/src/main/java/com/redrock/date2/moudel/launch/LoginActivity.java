package com.redrock.date2.moudel.launch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginPresenter> {

    @InjectView(R.id.phone)
    TextView phone;
    @InjectView(R.id.password)
    TextView password;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.register)
    TextView register;
    @InjectView(R.id.find_password)
    TextView findPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity_login);
        ButterKnife.inject(this);
        register.setOnClickListener(v->startActivity(new Intent(this,RegisterActivity.class)));
    }
}
