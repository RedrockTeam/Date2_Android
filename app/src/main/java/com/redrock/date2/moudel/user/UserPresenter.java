package com.redrock.date2.moudel.user;

import android.content.Intent;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.moudel.launch.LoginActivity;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class UserPresenter extends Presenter<UserFragment> {
    @Override
    protected void onCreateView(UserFragment view) {
        super.onCreateView(view);
        getView().setUser(UserModel.getInstance().getAccount());
        UserModel.getInstance().registerUserChange(user -> getView().setUser(user));
    }


    public boolean checkLogin(){
        if (UserModel.getInstance().getAccount()==null){
            getView().startActivity(new Intent(getView().getActivity(), LoginActivity.class));
            return false;
        }else{
            return true;
        }
    }

    public void startUserDetail(){
        if (checkLogin()){
            Intent i = new Intent(getView().getActivity(),UserDetailActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }
    }

    public void startAttention(){
        if (checkLogin()) {
            Intent i = new Intent(getView().getActivity(), AttentionActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }
    }
    public void startFans(){
        if (checkLogin()){
            Intent i = new Intent(getView().getActivity(), FansActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }

    }
    public void startJoinDate(){
        if (checkLogin()){
            Intent i = new Intent(getView().getActivity(),JoinDateActivity.class);
            i.putExtra("id",UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }

    }
    public void startCollection(){
        if (checkLogin()){
            Intent i = new Intent(getView().getActivity(),CollectionDateActivity.class);
            i.putExtra("id",UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }


    }

    public void startContact(){
        if (checkLogin()) {
            Intent i = new Intent(getView().getActivity(), ContactActivity.class);
            i.putExtra("id", UserModel.getInstance().getAccount().getId());
            getView().startActivity(i);
        }
    }

    public void startCertification(){
        if (checkLogin()) {
            Intent i = new Intent(getView().getActivity(), CertificationActivity.class);
            getView().startActivity(i);
        }
    }
}
