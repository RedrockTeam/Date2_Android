package com.redrock.date2.moudel.date;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Comment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(CommentPresenter.class)
public class CommentActivity extends BeamListActivity<CommentPresenter,Comment> {

    @InjectView(R.id.content)
    EditText content;
    @InjectView(R.id.send)
    TextView send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.date_activity_comment;
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(parent);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig().
                setNoMoreAble(true).
                setRefreshAble(true).
                setRefreshAble(true).
                setLoadMoreRes(R.layout.view_list_more).
                setErrorTouchToResumeAble(true);
    }
}
