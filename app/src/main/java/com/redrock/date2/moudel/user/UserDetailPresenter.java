package com.redrock.date2.moudel.user;

import android.content.Intent;
import android.os.Bundle;

import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class UserDetailPresenter extends BeamDataActivityPresenter<UserDetailActivity,UserDetail> {

    @Override
    protected void onCreate(UserDetailActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        getView().getExpansion().showProgressPage();
        UserModel.getInstance().getUserDetail(getView().getIntent().getStringExtra("id"), new DataCallback<UserDetail>() {
            @Override
            public void success(String info, UserDetail data) {
                if (getView() != null) {
                    getView().getExpansion().dismissProgressPage();
                    publishObject(data);
                }
            }

            @Override
            public void error(String errorInfo) {
                getView().getExpansion().showErrorPage();
            }
        });
    }


    public void startAttention(){
            Intent i = new Intent(getView(), AttentionActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);

    }
    public void startFans(){
            Intent i = new Intent(getView(), FansActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
    }

    public void startJoinDate(){
            Intent i = new Intent(getView(),JoinDateActivity.class);
            i.putExtra("id",UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
    }
    public void startCollection(){
            Intent i = new Intent(getView(),CollectionDateActivity.class);
            i.putExtra("id",UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
    }

}
