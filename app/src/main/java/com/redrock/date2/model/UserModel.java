package com.redrock.date2.model;

import android.content.Context;

import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.TokenParams;
import com.redrock.date2.config.API;
import com.redrock.date2.config.Dir;
import com.redrock.date2.model.bean.Account;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;
import com.redrock.date2.model.callback.StatusCallback;

import java.util.Random;

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
    private UserDetail account;
    private BehaviorSubject<UserDetail> mUserBehaviorSubject;
    private BehaviorSubject<Account> mAccountBehaviorSubject;
    @Override
    protected void onAppCreateOnBackThread(Context ctx) {
        super.onAppCreateOnBackThread(ctx);
        mUserBehaviorSubject = BehaviorSubject.create();
        mAccountBehaviorSubject = BehaviorSubject.create();
        getAccount();
    }

    public String getToken(){
        return "";
    }

    public void registerUserChange(Action1<UserDetail> action1){
        mUserBehaviorSubject.subscribe(action1);
    }
    public void registerRegisterListener(Action1<Account> action1){
        mAccountBehaviorSubject.subscribe(action1);
    }
    public UserDetail getAccount(){
        if (account!=null)return account;
        else return (UserDetail) JFileManager.getInstance().getFolder(Dir.Object).readObjectFromFile(ACCOUNT_FILE);
    }

    public void setAccount(UserDetail user){
        JUtils.Log("Login in");
        account = user;
        if (user != null)
            JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(user,ACCOUNT_FILE);
        else
            JFileManager.getInstance().getFolder(Dir.Object).deleteChild(ACCOUNT_FILE);

        //一定要在最后
        mUserBehaviorSubject.onNext(user);
    }

    public void login(String number,String password,DataCallback<UserDetail> callback){
        RequestMap params = new RequestMap();
        params.put("loginUser",number);
        params.put("password", password);
        RequestManager.getInstance().post(API.URL.Login, params, callback.add(new DataCallback<UserDetail>() {
            @Override
            public void success(String info, UserDetail data) {
                setAccount(data);
            }
        }));
    }
    public void register(String tel,String password,String code,int gender,String nickname,StatusCallback callback){
        RequestMap params = new RequestMap();
        params.put("tel",tel);
        params.put("password", password);
        params.put("code", code);
        params.put("nickname", nickname);
        params.put("gender", gender+"");
        RequestManager.getInstance().post(API.URL.Register, params, callback.add(new StatusCallback() {
            @Override
            public void success(String info) {
                mAccountBehaviorSubject.onNext(new Account(tel,password));
            }
        }));
    }

    public void findPassword(String number,String code,String password,DataCallback<User> callback){
        RequestMap params = new RequestMap();
        params.put("phone",number);
        params.put("code",code);
        params.put("password", password);
        RequestManager.getInstance().post(API.URL.Pwdfind, params, callback);
    }

    public void certification(String number,String school,String realName,String stuCard,DataCallback<User> callback){
        RequestMap params = new TokenParams();
        params.put("phone",number);
        params.put("realName",realName);
        params.put("school", school);
        params.put("stuCard", stuCard);
        RequestManager.getInstance().post(API.URL.Pwdfind, params, callback);
    }


    public void LoginOut(){
        setAccount(null);
    }


    public void getUserDetail(String id , DataCallback<UserDetail> callback){
        //new Handler().postDelayed(() -> callback.success("", createVirtualUserDetail()), 1000);
    }

    public void getAttention(String id, DataCallback<User[]> callback){
        //new Handler().postDelayed(() -> callback.success("",createVirtualUsers(20)), 1000);
    }


    public User createEmptyUser(){
        return new User(
                "0",JUtils.getUriFromRes(R.id.ic_person).getPath(),"","",1,2010,0
        );
    }

    public User[] createVirtualUsers(int count){
        User[] users = new User[count];
        for (int i = 0; i < users.length; i++) {
            users[i] = createVirtualUser();
        }
        return users;
    }

//    public UserDetail createVirtualUserDetail(){
//        Random r= new Random();
//        return new UserDetail(
//                "1",
//                "http://i2.hdslb.com/user/1244/124416/myface.jpg",
//                "Jude",
//                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
//                r.nextInt(2),2010+r.nextInt(6),true,
//                "128","56","宋伊雪",
//                "吃货 运动狂魔",
//                "山东蓝翔",
//                "12580");
//    }
//
    public User createVirtualUser(){
        Random r= new Random();
        return new User(
                "1",
                "http://i2.hdslb.com/user/1244/124416/myface.jpg",
                "Jude",
                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
                r.nextInt(2),2010+r.nextInt(6),1);
    }

    public void modifyFace(String originalImage, StatusCallback callback) {

    }
}
