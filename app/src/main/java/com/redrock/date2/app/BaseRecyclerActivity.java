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
import com.jude.utils.JUtils;
import com.redrock.date2.R;

/**
 * Created by zhuchenxi on 15/6/8.
 */
public abstract class BaseRecyclerActivity<T extends Presenter,E> extends BaseActivity<T> {
    protected EasyRecyclerView recyclerView;
    protected DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapterWithProgress(adapter = new DataAdapter(this));
        adapter.setNoMore(R.layout.view_list_nomore);
    }

    public int getLayout(){
        return R.layout.activity_recyclerview;
    }

    public void setRefreshAble(){
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                BaseRecyclerActivity.this.onRefresh();
            }
        });
    }

    public void setLoadMoreAble(){
        adapter.setMore(R.layout.view_list_more, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                BaseRecyclerActivity.this.onLoadMore();
            }
        });
    }

    public DataAdapter getAdapter(){
        return adapter;
    }

    protected void onRefresh(){}
    protected void onLoadMore(){}
    protected abstract BaseViewHolder getViewHolder(ViewGroup parent,int viewType);
    protected int getViewType(int position){return 0;}

    public void addData(E[] data){
        JUtils.Log("addData");
        adapter.addAll(data);
    }


    //添加数据
    public void clear(E[] data){
        adapter.clear();
    }

    //当最后一页，手动调用
    public void stopLoadMore() {
        adapter.stopMore();
    }

    //可以主动调用
    public void startRefresh() {
        recyclerView.getSwipeToRefresh().setRefreshing(true);
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
