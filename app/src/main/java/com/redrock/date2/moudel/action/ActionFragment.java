package com.redrock.date2.moudel.action;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.model.bean.Action;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(ActionPresenter.class)
public class ActionFragment extends BeamListFragment<ActionPresenter,Action> {

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new ActionViewHolder(viewGroup);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true).setLoadmoreAble(true).setErrorTouchToResumeAble(true);
    }
}
