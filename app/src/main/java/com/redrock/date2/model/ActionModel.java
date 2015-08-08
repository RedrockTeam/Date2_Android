package com.redrock.date2.model;

import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.redrock.date2.model.bean.Action;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class ActionModel extends AbsModel {

    public static ActionModel getInstance() {
        return getInstance(ActionModel.class);
    }

    public void getAction(int page,DataCallback<Action[]> callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("",createVirtualAction(20));
            }
        }, 1000);
    }

    private Action[] createVirtualAction(int count){
        Action[] actions = new Action[count];
        for (int i = 0; i < actions.length; i++) {
            actions[i] = new Action("http://i1.hdslb.com/promote/d26db380c0b05ff587abc9a099f27210.png",
                    "扒一扒 开源发家史；Linux在为谁代言？",
                    "前十包路费",
                    "5","8","125");
        }
        return actions;
    }
}
