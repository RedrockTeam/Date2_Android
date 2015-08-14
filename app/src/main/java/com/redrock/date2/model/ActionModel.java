package com.redrock.date2.model;

import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.redrock.date2.model.bean.Action;
import com.redrock.date2.model.bean.ActionDetail;
import com.redrock.date2.model.bean.User;
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

    public void getActionDetail(String id,DataCallback<ActionDetail> callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("",createVirtualActionDetail());
            }
        }, 1000);
    }

    private ActionDetail createVirtualActionDetail(){
        return new ActionDetail(
                "http://i2.hdslb.com/video/9c/9ceb2746b40aea8e7077f7d3cab645c6.jpg",
                "大圣我要给你生猴子",
                "前十包路费",
                "5","8","125",1439031592,"广东省肇庆市境东北部","78.00元",
                "鼎湖山位于广东省肇庆市境东北部，距肇庆市区18公里，位于北纬23°10’，东经112°31’。是北回归线上唯一的绿洲，因此鼎湖山被誉为“北回归线上的绿宝石”。不仅如此，由于鼎湖山枝繁叶茂，负离子含量之高，也因此被誉为“天然氧气库”。并与韶关丹霞山、博罗罗浮山、佛山西樵山合称为广东省四大名山",
                new User[]{
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                },
                DateModel.getInstance().createVirtualComments(10)

        );
    }

    private Action[] createVirtualAction(int count){
        Action[] actions = new Action[count];
        for (int i = 0; i < actions.length; i++) {
            actions[i] = new Action("http://i1.hdslb.com/promote/b6aca04e368abd99f244731e0cf518e7.jpg",
                    "扒一扒 开源发家史；Linux在为谁代言？",
                    "前十包路费",
                    "5","8","125");
        }
        return actions;
    }
}
