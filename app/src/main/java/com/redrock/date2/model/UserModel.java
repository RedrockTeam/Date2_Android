package com.redrock.date2.model;

import android.content.Context;
import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.config.Dir;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;

import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class UserModel extends AbsModel{
    public static UserModel getInstance() {
        return getInstance(UserModel.class);
    }
    public static final String ACCOUNT_FILE = "account";
    private User account;
    private BehaviorSubject<User> mUserBehaviorSubject;

    @Override
    protected void onAppCreateOnBackThread(Context ctx) {
        super.onAppCreateOnBackThread(ctx);
        mUserBehaviorSubject = BehaviorSubject.create();
        getAccount();
    }

    public void registerUserChange(Action1<User> action1){
        mUserBehaviorSubject.subscribe(action1);
    }

    public User getAccount(){
        if (account!=null)return account;
        else return (User) JFileManager.getInstance().getFolder(Dir.Object).readObjectFromFile(ACCOUNT_FILE);
    }

    public void setAccount(User user){
        JUtils.Log("Login in");
        account = user;
        if (user != null)
            JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(user,ACCOUNT_FILE);
        else
            JFileManager.getInstance().getFolder(Dir.Object).deleteChild(ACCOUNT_FILE);

        //一定要在最后
        mUserBehaviorSubject.onNext(user);
    }

    public void login(String number,String password,DataCallback<User> callback){
        callback.add(new DataCallback<User>() {
            @Override
            public void success(String info, User data) {
                setAccount(data);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("", createVirtualUser());
                //TODO 临时处理callback不能链式调用的问题
                setAccount(createVirtualUser());
            }
        }, 1000);
    }

    public void LoginOut(){
        setAccount(null);
    }


    public void getUserDetail(String id , DataCallback<UserDetail> callback){
        new Handler().postDelayed(() -> callback.success("", createVirtualUserDtail()), 1000);
    }

    public void getAttention(String id, DataCallback<User[]> callback){
        new Handler().postDelayed(() -> callback.success("",createVirtualUsers(20)), 1000);
    }


    public User createEmptyUser(){
        return new User(
                "0",JUtils.getUriFromRes(R.id.ic_person).getPath(),"","","",""
        );
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
