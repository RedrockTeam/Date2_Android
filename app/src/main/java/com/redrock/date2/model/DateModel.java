package com.redrock.date2.model;

import android.content.Context;
import android.os.Handler;

import com.jude.beam.model.AbsModel;
import com.jude.utils.JFileManager;
import com.redrock.date2.config.Dir;
import com.redrock.date2.model.bean.Banner;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.bean.DateType;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DateModel extends AbsModel {
    public static final String DATE_TYPE_FILE = "dateType";
    private DateType[] mDateType;
    public static DateModel getInstance() {
        return getInstance(DateModel.class);
    }

    @Override
    protected void onAppCreateOnBackThread(Context ctx) {
        setVirtualDateType();
        mDateType = (DateType[]) JFileManager.getInstance().getFolder(Dir.Object).readObjectFromFile(DATE_TYPE_FILE);
    }

    public void getBanner(DataCallback<Banner[]> callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.success("",creatVirtualBanner());
            }
        }, 1000);
    }

    public void getDate(int page,int type ,DataCallback<Date[]> callback){
        new Handler().postDelayed(() -> callback.success("",createVirtualDate(20)),1000);
    }

    public DateType[] getDateType(){
        return mDateType == null?new DateType[0]:mDateType;
    }

    public void setDateType(DateType[] types){
        mDateType = types;
        JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(types,DATE_TYPE_FILE);
    }

    public Date[] createVirtualDate(int count){
        Date[] dates = new Date[count];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date("http://i2.hdslb.com/account/face/5871456/ccf106b0/myface.png",
                    "Jude",
                    "当电影遇到移动短视频，又一轮内容UGC在爆发",
                    1439081137,
                    5,
                    1439000137,
                    "工信部已经推行了很久的“手机实名制”",
                    "AA制",
                    "3","5","8");
        }
        return dates;
    }

    public void setVirtualDateType(){
        DateType[] types = new DateType[9];
        types[0] = new DateType("热门",0);
        types[1] = new DateType("拼车",0);
        types[2] = new DateType("棋牌",0);
        types[3] = new DateType("看电影",0);
        types[4] = new DateType("学习",0);
        types[5] = new DateType("比赛",0);
        types[6] = new DateType("= =",0);
        types[7] = new DateType("打炮",0);
        types[8] = new DateType("吃饭",0);
        JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(types,DATE_TYPE_FILE);
    }

    public Banner[] creatVirtualBanner(){
        Banner[] banner = new Banner[3];
        banner[0] = new Banner("http://i2.hdslb.com/promote/e1a20d59ef57ee7821b0e934ced3a483.jpg");
        banner[1] = new Banner("http://i1.hdslb.com/promote/94980e5b2afc41e6fbac5b90eb0490f1.png");
        banner[2] = new Banner("http://i2.hdslb.com/promote/260fbde129e26ea20b46578627241989.jpg");
        return banner;
    }
}
