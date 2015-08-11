package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class UserDetailPresenter extends Presenter<UserDetailActivity> {
    private UserDetail userDetail;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        UserModel.getInstance().getUserDetail(getView().getIntent().getStringExtra("id"), new DataCallback<UserDetail>() {
            @Override
            public void success(String info, UserDetail data) {
                if (getView()!=null)
                    getView().setUserDetail(userDetail = data);
            }
        });
    }

    @Override
    protected void onCreateView(UserDetailActivity view) {
        super.onCreateView(view);
        if (userDetail!=null)getView().setUserDetail(userDetail);
    }
}
