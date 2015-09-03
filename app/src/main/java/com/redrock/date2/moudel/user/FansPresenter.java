package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class FansPresenter extends BeamListActivityPresenter<FansActivity,User> {
    private String id;
    private User[] users;
    @Override
    protected void onCreate(FansActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        id = getView().getIntent().getStringExtra("id");
        onRefresh();
    }

    @Override
    public void onRefresh() {
        UserModel.getInstance().getAttention("0", new DataCallback<User[]>() {
            @Override
            public void success(String info, User[] data) {
                getAdapter().clear();
                getAdapter().addAll(data);
            }

            @Override
            public void error(String errorInfo) {
                getView().showError();
            }
        });
    }
}
