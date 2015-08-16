package com.redrock.date2.moudel.user;

import android.content.Intent;
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
        getView().addLoadingView();
        UserModel.getInstance().getUserDetail(getView().getIntent().getStringExtra("id"), new DataCallback<UserDetail>() {
            @Override
            public void success(String info, UserDetail data) {
                if (getView() != null){
                    getView().removeLoadingView();
                    getView().setUserDetail(userDetail = data);
                    getView().setIsUser(userDetail.getId().equals(UserModel.getInstance().getAccount().getId()));
                }

            }
        });
    }

    @Override
    protected void onCreateView(UserDetailActivity view) {
        super.onCreateView(view);
        if (userDetail!=null){
            getView().setUserDetail(userDetail);
            getView().setIsUser(userDetail.getId().equals(UserModel.getInstance().getAccount().getId()));
        }
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
