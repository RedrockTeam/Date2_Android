package com.redrock.date2.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.redrock.date2.R;

/**
 * Created by zhuchenxi on 15/6/8.
 */
public abstract class BaseRecyclerActivity<T extends Presenter,E> extends BaseActivity<T> {
    protected EasyRecyclerView recyclerView;
    protected DataAdapter adapter;
    private RecyclerArrayAdapter.ItemView mEmptyFooter;
    private boolean isMoreAble = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapterWithProgress(adapter = new DataAdapter(this));
        adapter.setNoMore(R.layout.view_list_nomore);
    }

    public void setRefreshAble(){
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startRefresh();
            }
        });
    }

    public void setLoadMoreAble(){
        isMoreAble = true;
    }

    public DataAdapter getAdapter(){
        return adapter;
    }

    protected void onRefresh(){}
    protected void onLoadMore(){}
    protected abstract BaseViewHolder getViewHolder(ViewGroup parent,int viewType);
    protected int getViewType(int position){return 0;}

    public void addData(E[] data){
        adapter.addAll(data);
    }


    //添加数据
    public void addDataWithRefresh(E[] data){
        adapter.clear();
        adapter.addAll(data);
        if (isMoreAble)adapter.setMore(R.layout.view_list_more, () -> onLoadMore());
    }

    //当最后一页，手动调用
    public void stopLoadMore() {
        adapter.stopMore();
    }

    //可以主动调用
    public void startRefresh() {
        recyclerView.getSwipeToRefresh().setRefreshing(true);
        adapter.removeFooter(mEmptyFooter);
        adapter.stopMore();
        onRefresh();
    }


    protected class DataAdapter extends RecyclerArrayAdapter<E> {

        public DataAdapter(Context context) {
            super(context);
        }

        @Override
        public int getViewType(int position) {
            return BaseRecyclerActivity.this.getViewType(position);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return getViewHolder(parent,viewType);
        }
    }
}
