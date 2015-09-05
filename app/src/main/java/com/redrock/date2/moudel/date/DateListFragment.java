package com.redrock.date2.moudel.date;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Date;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(DateListPresenter.class)
public class DateListFragment extends BeamListFragment<DateListPresenter,Date> {
    @Override
    public int getLayout() {
        return R.layout.include_recyclerview;
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new DateViewHolder(viewGroup);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig().setLoadmoreAble(true);
    }
}
