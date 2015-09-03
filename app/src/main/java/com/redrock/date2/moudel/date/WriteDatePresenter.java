package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateEdit;
import com.redrock.date2.model.callback.StatusCallback;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class WriteDatePresenter extends Presenter<WriteDateActivity> {
    public DateEdit mData = new DateEdit();

    @Override
    protected void onCreate(WriteDateActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        mData.setStyle(getView().getIntent().getIntExtra("id", 0));
    }

    @Override
    protected void onCreateView(WriteDateActivity view) {
        super.onCreateView(view);
        getView().setDateType(DateModel.getInstance().findDateTypeFatherById(mData.getStyle()));
    }

    public void setTitle(String title){
        mData.setTitle(title);
    }

    public void setMemberCount(int count){
        mData.setMemberCount(count);
    }

    public void setCostType(int index){
        mData.setCostType(index);
    }

    public void setTime(long time){
        mData.setTime(time);
    }

    public void setAddress(String address){
        mData.setAddress(address);
    }

    public void setContent(String content){
        mData.setContent(content);
    }


    public void setGender(int type){
        mData.setGender(type);
    }

    public void setSchool(String school){
        mData.setSchool(school);
    }

    public void publish(){
        if (mData.getTitle() == null || mData.getTitle().trim().isEmpty()){
            JUtils.Toast("请输入标题");
            return ;
        }
        if (mData.getMemberCount() == 0){
            JUtils.Toast("请输入人数");
            return ;
        }
        if (mData.getCostType() == -1){
            JUtils.Toast("请选择花费模式");
            return ;
        }
        if (mData.getTime() == 0){
            JUtils.Toast("请选择约会时间");
            return;
        }
        if (mData.getAddress() == null || mData.getAddress().trim().isEmpty()){
            JUtils.Toast("请输入地点");
            return ;
        }
        getView().getExpansion().showProgressDialog("发表中");
        DateModel.getInstance().publishDate(mData, new StatusCallback() {
            @Override
            public void success(String info) {
                getView().finish();
            }

            @Override
            public void result(int status, String info) {
                getView().getExpansion().dismissProgressDialog();
            }
        });
    }

}
