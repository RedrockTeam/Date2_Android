package com.redrock.date2.moudel.date;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseRecyclerActivity;
import com.redrock.date2.model.bean.Comment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(CommentPresenter.class)
public class CommentActivity extends BaseRecyclerActivity<CommentPresenter,Comment> {

    @InjectView(R.id.content)
    EditText content;
    @InjectView(R.id.send)
    TextView send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        setLoadMoreAble();
    }

    @Override
    public int getLayout() {
        return R.layout.date_activity_comment;
    }

    @Override
    protected void onLoadMore() {
        getPresenter().loadMore();
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(parent);
    }
}
