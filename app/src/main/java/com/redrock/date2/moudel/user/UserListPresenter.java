package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.bean.User;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class UserListPresenter extends Presenter<UserListActivity> {
    private User[] users;
    private String title;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        users = (User[]) getView().getIntent().getSerializableExtra("users");
        title = getView().getIntent().getStringExtra("title");
    }

    @Override
    protected void onCreateView(UserListActivity view) {
        super.onCreateView(view);
        getView().getSupportActionBar().setTitle(title);
        if (users!=null)getView().addData(users);
    }
}
