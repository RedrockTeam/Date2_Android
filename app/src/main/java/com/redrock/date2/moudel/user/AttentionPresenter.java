package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class AttentionPresenter extends Presenter<AttentionActivity> {
    private String id;
    private User[] users;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        id = getView().getIntent().getStringExtra("id");
        UserModel.getInstance().getAttenttion("0", new DataCallback<User[]>() {
            @Override
            public void success(String info, User[] data) {
                getView().addData(users = data);
            }
        });
    }

    @Override
    protected void onCreateView(AttentionActivity view) {
        super.onCreateView(view);
        if (users!=null)getView().addData(users);
    }
}
