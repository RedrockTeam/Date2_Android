package com.redrock.date2.moudel.user;

import android.content.Intent;

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

    public void startUserDetail(){
        Intent i = new Intent(getView().getActivity(),UserDetailActivity.class);
        i.putExtra("id", UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }

    public void startAttention(){
        Intent i = new Intent(getView().getActivity(),AttentionActivity.class);
        i.putExtra("id",UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }
    public void startFans(){
        Intent i = new Intent(getView().getActivity(),FansActivity.class);
        i.putExtra("id",UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }
    public void startJoinDate(){
        Intent i = new Intent(getView().getActivity(),JoinDateActivity.class);
        i.putExtra("id",UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }
    public void startCollection(){
        Intent i = new Intent(getView().getActivity(),CollectionDateActivity.class);
        i.putExtra("id",UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }

    public void startContact(){
        Intent i = new Intent(getView().getActivity(),ContactActivity.class);
        i.putExtra("id",UserModel.getInstance().getAccount().getId());
        getView().startActivity(i);
    }

    public void startCertification(){
        Intent i = new Intent(getView().getActivity(),CertificationActivity.class);
        getView().startActivity(i);
    }
}
