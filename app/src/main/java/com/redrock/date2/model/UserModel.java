package com.redrock.date2.model;

import com.jude.beam.model.AbsModel;
import com.redrock.date2.model.bean.User;

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

    public User createVirtualUser(){
        return new User("http://i2.hdslb.com/user/1244/124416/myface.jpg",
                "Jude",
                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
                "128","56");
    }
}
