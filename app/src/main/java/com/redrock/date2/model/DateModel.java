package com.redrock.date2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.redrock.date2.app.TokenParams;
import com.redrock.date2.config.API;
import com.redrock.date2.config.Dir;
import com.redrock.date2.model.bean.Banner;
import com.redrock.date2.model.bean.Comment;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.bean.DateDetail;
import com.redrock.date2.model.bean.DateEdit;
import com.redrock.date2.model.bean.DateType;
import com.redrock.date2.model.bean.DateTypeFather;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;
import com.redrock.date2.model.callback.StatusCallback;

import java.util.Random;

import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DateModel extends AbsModel {
    public static final String DATE_TYPE_FILE = "dateType";
    public static final String FILTRATE_TYPE = "filtrate_type";
    public static final String FILTRATE_STYLE = "filtrate_style";
    public static final String FILTRATE_USER = "filtrate_user";
    public static final String FILTRATE_TIME = "filtrate_time";
    public static final String FILTRATE_COST = "filtrate_cost";

    private DateTypeFather[] mDateType;
    private BehaviorSubject<DateTypeFather[]> mDateTypeSubject;
    public static DateModel getInstance() {
        return getInstance(DateModel.class);
    }

    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
        mDateType = (DateTypeFather[]) JFileManager.getInstance().getFolder(Dir.Object).readObjectFromFile(DATE_TYPE_FILE);
        mDateTypeSubject = BehaviorSubject.create();
        mDateTypeSubject.onNext(mDateType);
    }

    @Override
    protected void onAppCreateOnBackThread(Context ctx) {
        updateDateType();
    }

    public Subscription registerDateTypeFather(Action1<DateTypeFather[]> action1){
        return mDateTypeSubject.subscribe(action1);
    }

    public void getBanner(DataCallback<Banner[]> callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("", createVirtualBanner());
            }
        }, 1000);
    }

    public void getDate(int page,int type ,DataCallback<Date[]> callback){
        RequestMap params = new RequestMap();
        params.put("page",page+"");
        params.put("sortLimit",getFiltrateStyle()+"");
        params.put("genderLimit",getFiltrateUser()+"");
        params.put("paymentLimit",getFiltrateCost()+"");
        params.put("timeLimit",getFiltrateTime()+"");
        params.put("dateType",type+"");
        RequestManager.getInstance().post(API.URL.DateList, params, callback);
    }

    public void getJoinDate(DataCallback<Date[]> callback){
        new Handler().postDelayed(() -> callback.success("", createVirtualDate(20)), 1000);
    }

    public DateTypeFather[] getDateTypeFather(){
        return mDateType == null?new DateTypeFather[0]:mDateType;
    }

    public DateTypeFather findDateTypeFatherById(int id){
        for (DateTypeFather dateType : getDateTypeFather()) {
            if (dateType.getId() == id)return dateType;
        }
        return null;
    }

    public void setDateType(DateTypeFather[] types){
        JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(types, DATE_TYPE_FILE);
        mDateType = types;
        if (mDateType!=null)
        mDateTypeSubject.onNext(types);
        JUtils.Log("save Type" + types.length);
    }


    public void updateDateType(){
        RequestManager.getInstance().post(API.URL.DateType, null, new DataCallback<DateTypeFather[]>() {
            @Override
            public void success(String info, DateTypeFather[] data) {
                setDateType(data);
            }
        });
    }


    public void publishDate(DateEdit dateEdit,StatusCallback callback){
        TokenParams params = new TokenParams();
        params.put("title",dateEdit.getTitle());
        params.put("content",dateEdit.getContent());
        params.put("date_time",dateEdit.getTime()+"");
        params.put("date_place",dateEdit.getAddress());
        params.put("date_type",dateEdit.getStyle()+"");
        params.put("cost_type",dateEdit.getCostType()+"");
        params.put("gender_limit",dateEdit.getGender()+"");
        params.put("people_limit",dateEdit.getMemberCount()+"");
        RequestManager.getInstance().post(API.URL.PublishDate,params,callback);
    }

    public void getDateDetail(String id,DataCallback<DateDetail> callback){
        new Handler().postDelayed(() -> callback.success("", createVirtualDateDetail()), 1000);
    }

    public void getComments(String id,int page,DataCallback<Comment[]> callback){
        new Handler().postDelayed(() -> callback.success("", createVirtualComments(20)), 1000);
    }

    public void saveFiltrate(int typeFather,int type,int style,int user,int time,int cost){
        SharedPreferences.Editor editor = JUtils.getSharedPreference().edit();
        editor.putInt(FILTRATE_TYPE + typeFather, type);
        editor.putInt(FILTRATE_STYLE,style);
        editor.putInt(FILTRATE_USER,user);
        editor.putInt(FILTRATE_TIME,time);
        editor.putInt(FILTRATE_COST, cost);
        editor.apply();
    }
    public int getFiltrateType(int typeFather){
        return JUtils.getSharedPreference().getInt(FILTRATE_TYPE+typeFather,0);
    }
    public int getFiltrateStyle(){return JUtils.getSharedPreference().getInt(FILTRATE_STYLE,0);}
    public int getFiltrateUser(){return JUtils.getSharedPreference().getInt(FILTRATE_USER,0);}
    public int getFiltrateTime(){return JUtils.getSharedPreference().getInt(FILTRATE_TIME,0);}
    public int getFiltrateCost(){return JUtils.getSharedPreference().getInt(FILTRATE_COST,0);}

    public DateDetail createVirtualDateDetail(){
        return new DateDetail(3,
                "专车司机：月入两三万的日子一去不复返",
                3,
                1,
                1439829764,
                "北京市东花市北里20号楼6单元501室",
                0,
                "山东蓝翔",
                "【TechWeb报道】8月10日消息，搜狐在提交给监管部门的文件中透露，游戏子公司畅游作价2.05亿美元向第三方转让了三家子公司，其中包括两家海外子公司。",
                1439129764,
                new User[]{
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                        UserModel.getInstance().createVirtualUser(),
                },
                UserModel.getInstance().createVirtualUser(),
                createVirtualComments(10));
    }

    public Comment[] createVirtualComments(int count){
        Random r= new Random();
        Comment[] comments = new Comment[count];
        for (int i = 0; i < comments.length; i++) {
            comments[i] = new Comment(
                    "http://i2.hdslb.com/account/face/12278054/2a44a170/myface.png",
                    "宋伊雪",r.nextInt(2),2010+r.nextInt(6),true,
                    "前几天下了一场雨，我站在阳台看着雨后的城市，落日是粉红色的，突然想起曾有个姑娘跟我说想要看到粉红色的太阳，心里一阵触动。",
                    1439270903
            );
        }
        return comments;
    }

    public Date[] createVirtualDate(int count){
        Date[] dates = new Date[count];
        Random r= new Random();
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date("1","http://i2.hdslb.com/account/face/5871456/ccf106b0/myface.png",
                    "Jude",r.nextInt(2),2008+r.nextInt(8),1,
                    "当电影遇到移动短视频，又一轮内容UGC在爆发",
                    1439081137,
                    r.nextInt(DateModel.getInstance().getDateTypeFather().length-2)+1,
                    1439000137,
                    "工信部已经推行了很久的“手机实名制”",
                    "AA制",
                    "3","5","8",1);
        }
        return dates;
    }

    public void setVirtualDateType(){
        DateType[] types = new DateType[7];
        types[0] = new DateType("吃饭",1);
        types[1] = new DateType("拼车",2);
        types[2] = new DateType("棋牌",3);
        types[3] = new DateType("看电影",4);
        types[4] = new DateType("学习",5);
        types[5] = new DateType("比赛",6);
        types[6] = new DateType("实在不知道还有什么分类",7);
        JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(types,DATE_TYPE_FILE);
    }

    public Banner[] createVirtualBanner(){
        Banner[] banner = new Banner[3];
        banner[0] = new Banner("http://i2.hdslb.com/promote/e1a20d59ef57ee7821b0e934ced3a483.jpg");
        banner[1] = new Banner("http://i1.hdslb.com/promote/94980e5b2afc41e6fbac5b90eb0490f1.png");
        banner[2] = new Banner("http://i2.hdslb.com/promote/260fbde129e26ea20b46578627241989.jpg");
        return banner;
    }
}
