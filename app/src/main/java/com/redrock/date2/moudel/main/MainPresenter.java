package com.redrock.date2.moudel.main;

import android.content.Intent;

import com.jude.beam.bijection.Presenter;
import com.redrock.date2.moudel.action.ActionFragment;
import com.redrock.date2.moudel.date.DateFragment;
import com.redrock.date2.moudel.date.WriteDateActivity;
import com.redrock.date2.moudel.message.MessageFragment;
import com.redrock.date2.moudel.user.UserFragment;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class MainPresenter extends Presenter<MainActivity> {
    private DateFragment mDateFragment;
    private ActionFragment mActionFragment;
    private MessageFragment mMessageFragment;
    private UserFragment mUserFragment;

    @Override
    protected void onCreateView(MainActivity view) {
        super.onCreateView(view);
        showDateFragment();
    }

    public void showDateFragment(){
        if (mDateFragment==null){
            mDateFragment = new DateFragment();
        }else{
            mDateFragment.showMain();
        }
        getView().showFragment(mDateFragment);
        getView().setFocus(0);
    }
    public void showActionFragment(){
        if (mActionFragment==null){
            mActionFragment = new ActionFragment();
        }
        getView().showFragment(mActionFragment);
        getView().setFocus(1);
    }
    public void showMessageFragment(){
        if (mMessageFragment==null){
            mMessageFragment = new MessageFragment();
        }
        getView().showFragment(mMessageFragment);
        getView().setFocus(2);
    }
    public void showUserFragment(){
        if (mUserFragment==null){
            mUserFragment = new UserFragment();
        }
        getView().showFragment(mUserFragment);
        getView().setFocus(3);
    }
    public void startPost(int typeId){
        Intent i = new Intent(getView(), WriteDateActivity.class);
        i.putExtra("id",typeId);
        getView().startActivity(i);
    }
}
