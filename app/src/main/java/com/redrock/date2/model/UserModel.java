package com.redrock.date2.model;

import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class UserModel extends AbsModel{

    public static UserModel getInstance() {
        return getInstance(UserModel.class);
    }

    public User getAccount(){
        return createVirtualUser();
    }

    public void getUserDetail(String id , DataCallback<UserDetail> callback){
        new Handler().postDelayed(() -> callback.success("",createVirtualUserDtail()), 1000);
    }

    public void getAttenttion(String id,DataCallback<User[]> callback){
        new Handler().postDelayed(() -> callback.success("",createVirtualUsers(20)), 1000);
    }

    public User[] createVirtualUsers(int count){
        User[] users = new User[count];
        for (int i = 0; i < users.length; i++) {
            users[i] = createVirtualUser();
        }
        return users;
    }
    public UserDetail createVirtualUserDtail(){
        return new UserDetail(
                "1",
                "http://i2.hdslb.com/user/1244/124416/myface.jpg",
                "Jude",
                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
                "128","56","宋伊雪",
                "吃货 运动狂魔",
                "山东蓝翔",
                "12580",
                false);
    }

    public User createVirtualUser(){
        return new User(
                "1",
                "http://i2.hdslb.com/user/1244/124416/myface.jpg",
                "Jude",
                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
                "128","56");
    }
}
