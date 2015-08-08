package com.redrock.date2.moudel.user;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class UserPresenter extends Presenter<UserFragment> {
    @Override
    protected void onCreateView(UserFragment view) {
        super.onCreateView(view);
        getView().setUser(UserModel.getInstance().getAccount());
    }
}
