package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.utils.JUtils;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Banner;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.callback.DataCallback;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class DateListPresenter extends Presenter<DateListFragment> {
    private int page = 0;
    private ArrayList<Date> mDateArrayList = new ArrayList<>();
    private int type;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        type = getView().getArguments().getInt("type");
        refresh();
        if(type == 0){
            DateModel.getInstance().getBanner(new DataCallback<Banner[]>() {
                @Override
                public void success(String info, Banner[] data) {
                    getView().setBanner(data);
                }
            });
        }
    }



    @Override
    protected void onTakeView(DateListFragment view) {
        super.onTakeView(view);
        JUtils.Log("onCreateView：" + mDateArrayList.size() + "  Hash:" + hashCode());
        if (mDateArrayList.size()!=0){
            getView().stopRefresh();
            getView().addDate(mDateArrayList.toArray(new Date[0]));
        }
    }

    public void refresh(){
        DateModel.getInstance().getDate(0,type ,new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                if (getView() !=null){
                    if (data == null ||data.length == 0) getView().stopRefresh();
                    else{
                        getView().stopRefresh();
                        getView().addDate(data);
                        mDateArrayList.clear();
                        mDateArrayList.addAll(Arrays.asList(data));
                        page = 1;
                    }
                }
            }
        });
    }

    public void loadMore(){
        DateModel.getInstance().getDate(page,type , new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                if (getView() !=null){
                    if (data == null ||data.length == 0) getView().stopLoadMore();
                    else  {
                        getView().addDate(data);
                        mDateArrayList.addAll(Arrays.asList(data));
                    }
                    page++;
                }
            }
        });
    }
}
