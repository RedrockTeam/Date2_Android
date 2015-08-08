package com.redrock.date2.moudel.date;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.redrock.date2.model.bean.Date;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class DateAdapter extends RecyclerArrayAdapter<Date> {
    public DateAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DateViewHolder(viewGroup);
    }
}
