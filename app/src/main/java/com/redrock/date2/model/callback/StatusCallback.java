package com.redrock.date2.model.callback;


import android.content.Intent;

import com.jude.utils.JActivityManager;
import com.jude.utils.JUtils;
import com.redrock.date2.config.API;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.moudel.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mr.Jude on 2015/5/25.
 */
public abstract class StatusCallback extends LinkCallback {
    @Override
    public void onRequest() {
        super.onRequest();
    }

    @Override
    public void onSuccess(String s) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(s);
            int status = jsonObject.getInt(API.KEY.STATUS);
            String info = jsonObject.getString(API.KEY.INFO);
            result(status, info);
            if(status == API.CODE.SUCCEED){
                success(info);
            } else {
                failure(status,info);
            }
        } catch (JSONException e) {
            result(-1,"数据解析错误");
            error("数据解析错误");
        }
        super.onSuccess(s);
    }

    @Override
    public void onError(String s) {
        result(-1,"网络错误");
        error("网络错误");
        super.onError(s);
    }

    public void result(int status, String info){}
    public abstract void success(String info);
    public void failure(int status,String info){
        JUtils.Log("failure");
        switch (status){
            case 102:
            case -109:
                authorizationFailure();
                break;
            case 1003:
                JUtils.Toast("您的账号已被冻结!");
                UserModel.getInstance().LoginOut();
                JActivityManager.getInstance().closeAllActivity();
                break;
            default:
                JUtils.Toast(info);
        }
    }
    public void error(String errorInfo){
        JUtils.Toast(errorInfo);
    }

    private void authorizationFailure(){
        JUtils.Toast("请重新登陆!");
        UserModel.getInstance().LoginOut();
        Intent i = new Intent(JActivityManager.getInstance().currentActivity(), MainActivity.class);
        JActivityManager.getInstance().currentActivity().startActivity(i);
        JActivityManager.getInstance().closeAllActivity();
    }
}
