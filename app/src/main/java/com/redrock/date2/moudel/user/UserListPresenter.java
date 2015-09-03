package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.redrock.date2.model.bean.User;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class UserListPresenter extends BeamListActivityPresenter<UserListActivity,User> {
    private User[] users;
    private String title;
    @Override
    protected void onCreate(UserListActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        users = (User[]) getView().getIntent().getSerializableExtra("users");
        title = getView().getIntent().getStringExtra("title");
    }

    @Override
    public void onRefresh() {
        getAdapter().clear();
        getAdapter().addAll(users);
    }

    @Override
    protected void onCreateView(UserListActivity view) {
        super.onCreateView(view);
        getView().getSupportActionBar().setTitle(title);
    }
}
