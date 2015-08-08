package com.redrock.date2.moudel.action;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.beam.nucleus.view.NucleusFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Action;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(ActionPresenter.class)
public class ActionFragment extends NucleusFragment<ActionPresenter> {
    private EasyRecyclerView mRecyclerView;
    private ActionAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.include_recyclerview,container,false);
        mRecyclerView = (EasyRecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mAdapter = new ActionAdapter(getActivity()));
        mRecyclerView.setRefreshListener(() -> getPresenter().refresh());
        mAdapter.setMore(R.layout.view_list_more, () -> getPresenter().loadMore());
        return view;
    }

    public void stopRefresh(){
        mAdapter.clear();
    }

    public void addDate(Action[] actions){
        mAdapter.addAll(actions);
    }

    public void stopLoadMore(){
        mAdapter.stopMore();
    }
}
