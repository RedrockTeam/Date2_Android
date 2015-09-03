package com.redrock.date2.moudel.user;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.moudel.date.DateViewHolder;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(CollectionDatePresenter.class)
public class CollectionDateActivity extends BeamListActivity<CollectionDatePresenter,Date> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new DateViewHolder(parent);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true);
    }
}
