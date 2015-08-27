package com.redrock.date2.moudel.launch;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
public class LoginPresenter extends Presenter<LoginActivity> {

    @Override
    protected void onCreateView(LoginActivity view) {
        super.onCreateView(view);
        UserModel.getInstance().registerRegisterListener(account -> getView().setAccount(account));
    }

    public void login(String number,String password){
        getView().showProgress("登录中");
        UserModel.getInstance().login(number, password, new DataCallback<UserDetail>() {
            @Override
            public void result(int status, String info) {
                getView().dismissProgress();
            }

            @Override
            public void success(String info, UserDetail data) {
                getView().dismissProgress();
                getView().finish();
            }
        });
    }

}
