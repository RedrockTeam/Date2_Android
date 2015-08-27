package com.redrock.date2.app;


import com.jude.http.RequestMap;
import com.redrock.date2.model.UserModel;
import java.io.File;

/**
 * Created by zhuchenxi on 15/5/11.
 */
public class TokenParams extends RequestMap {
    public TokenParams() {
        super();
        addToken();
    }

    public TokenParams(String key, String value) {
        super(key, value);
        addToken();
    }

    @Override
    public void put(String key, File file) {
        super.put(key, file);
        addToken();
    }

    private void addToken(){
        put("token",UserModel.getInstance().getToken());
        if (UserModel.getInstance().getAccount()!=null)
            put("uid",UserModel.getInstance().getAccount().getId());
    }
}
