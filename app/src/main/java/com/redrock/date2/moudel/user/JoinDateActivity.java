package com.redrock.date2.moudel.user;

import android.view.ViewGroup;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.app.BaseRecyclerActivity;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.moudel.date.DateViewHolder;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(JoinDatePresenter.class)
public class JoinDateActivity extends BaseRecyclerActivity<JoinDatePresenter,Date> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new DateViewHolder(parent);
    }
}
