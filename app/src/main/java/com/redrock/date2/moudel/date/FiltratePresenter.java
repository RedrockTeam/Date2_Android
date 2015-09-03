package com.redrock.date2.moudel.date;

import android.os.Bundle;
import com.jude.beam.bijection.Presenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateType;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class FiltratePresenter extends Presenter<FiltrateActivity> {
    private int mDateType;
    private DateType[] mTypes;
    int style;
    int user;
    int time;
    int cost;
    int type;

    public void setType(int type) {
        this.type = type == 0?mDateType:mTypes[type-1].getId();
    }

    public void setStyle(int index){
        this.style = index;
    }
    public void setUser(int index){
        this.user = index;
    }
    public void setCost(int index){
        this.cost = index;
    }
    public void setTime(int index){
        this.time = index;
    }

    @Override
    protected void onCreate(FiltrateActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        mDateType = getView().getIntent().getIntExtra("id",0);
    }

    public void save(){
        DateModel.getInstance().saveFiltrate(mDateType, type, style, user, time, cost);
        getView().finish();
    }

    @Override
    protected void onCreateView(FiltrateActivity view) {
        super.onCreateView(view);
        getView().setSortStyle(DateModel.getInstance().getFiltrateStyle());
        getView().setSortCost(DateModel.getInstance().getFiltrateCost());
        getView().setSortTime(DateModel.getInstance().getFiltrateTime());
        getView().setSortUser(DateModel.getInstance().getFiltrateUser());
        getView().setSortType(getDateTypeIndex());
    }

    public int getDateTypeIndex(){
        int typeId = DateModel.getInstance().getFiltrateType(mDateType);
        if (DateModel.getInstance().findDateTypeFatherById(mDateType)!=null){
            DateType[] typs = DateModel.getInstance().findDateTypeFatherById(mDateType).getChild();
            for (int i = 0; i < typs.length; i++) {
                if (typs[i].getId() == typeId)return i+1;
            }
        }
        return 0;
    }

    public String[] getDateType(){
        if (DateModel.getInstance().findDateTypeFatherById(mDateType)!=null){
            mTypes = DateModel.getInstance().findDateTypeFatherById(mDateType).getChild();
            String[] typeStrs = new String[mTypes.length+1];
            typeStrs[0] = "不限";
            for (int i = 0; i < mTypes.length; i++) {
                typeStrs[i+1] = mTypes[i].getName();
            }
            return typeStrs;
        }else{
            return new String[0];
        }


    }
}
