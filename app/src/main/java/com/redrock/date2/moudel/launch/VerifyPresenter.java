package com.redrock.date2.moudel.launch;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.utils.JUtils;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.callback.StatusCallback;

import cn.smssdk.gui.SMSManager;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
public class VerifyPresenter extends Presenter<VerifyActivity> {
    SMSManager smsManager;
    private String phone;
    private String name;
    private int gender;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        JUtils.Log("Presenter Begin");
        phone = getView().getIntent().getStringExtra("phone");
        name = getView().getIntent().getStringExtra("name");
        gender = getView().getIntent().getIntExtra("gender",1);
        smsManager = new SMSManager();
    }

    @Override
    protected void onCreateView(VerifyActivity view) {
        super.onCreateView(view);
        smsManager.registerTimeListener(getView());
        smsManager.sendMessage(getView(),phone);
    }

    public void reSendMessage(){
        smsManager.sendMessage(getView(),phone);
    }

    public void send(String code,String password){
        getView().showProgress("注册中");
        UserModel.getInstance().register(phone, password, code, gender, name, new StatusCallback() {
            @Override
            public void success(String info) {
                getView().finish();
            }

            @Override
            public void result(int status, String info) {
                getView().dismissProgress();
            }
        });
    }


}
