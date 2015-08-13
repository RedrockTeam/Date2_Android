package com.redrock.date2.moudel.launch;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
public class LoginPresenter extends Presenter<LoginActivity> {

    public void login(String number,String password){
        getView().showProgress("登录中");
        UserModel.getInstance().login(number, password, new DataCallback<User>() {
            @Override
            public void success(String info, User data) {
                getView().dismissProgress();
                getView().finish();
            }
        });
    }

}
