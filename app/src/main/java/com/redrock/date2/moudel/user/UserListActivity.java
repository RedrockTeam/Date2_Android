package com.redrock.date2.moudel.user;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.model.bean.User;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(UserListPresenter.class)
public class UserListActivity extends BeamListActivity<UserListPresenter,User> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(parent);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true);
    }
}
