package com.redrock.date2.moudel.date;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.DateModel;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class FiltratePresenter extends Presenter<FiltrateActivity> {
    int style;
    int user;
    int time;
    int cost;
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

    public void save(){
        DateModel.getInstance().saveFiltrate(style,user,time,cost);
        getView().finish();
    }

    @Override
    protected void onCreateView(FiltrateActivity view) {
        super.onCreateView(view);
        getView().setSortStyle(DateModel.getInstance().getFiltrateStyle());
        getView().setSortCost(DateModel.getInstance().getFiltrateCost());
        getView().setSortTime(DateModel.getInstance().getFiltrateTime());
        getView().setSortUser(DateModel.getInstance().getFiltrateUser());
    }
}
