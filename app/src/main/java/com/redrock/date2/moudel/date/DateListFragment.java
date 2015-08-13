package com.redrock.date2.moudel.date;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.beam.nucleus.view.NucleusFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Banner;
import com.redrock.date2.model.bean.Date;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(DateListPresenter.class)
public class DateListFragment extends NucleusFragment<DateListPresenter> {
    private EasyRecyclerView mRecyclerView;
    private DateAdapter mAdapter;
    private RecyclerArrayAdapter.ItemView mBannerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView = (EasyRecyclerView) inflater.inflate(R.layout.include_recyclerview,container,false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapterWithProgress(mAdapter = new DateAdapter(getActivity()));
        mRecyclerView.setRefreshListener(() -> getPresenter().refresh());
        mAdapter.setMore(R.layout.view_list_more, () -> getPresenter().loadMore());
        if (mBannerView!=null)mAdapter.addHeader(mBannerView);
        return mRecyclerView;
    }

    public void stopRefresh(){
        mAdapter.clear();
    }



    public void addDate(Date[] date){
        mAdapter.addAll(date);
    }

    public void stopLoadMore(){
        mAdapter.stopMore();
    }

    public void setBanner(Banner[] banner){
        if (mBannerView == null)
        mAdapter.addHeader(mBannerView = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup viewGroup) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.date_banner, viewGroup, false);
                RollPagerView vp = (RollPagerView) view.findViewById(R.id.view_pager);
                vp.setAdapter(new BannerAdapter());
                return view;
            }

            @Override
            public void onBindView(View view) {

            }

            class BannerAdapter extends StaticPagerAdapter{

                @Override
                public View getView(ViewGroup viewGroup, int i) {
                    SimpleDraweeView image = new SimpleDraweeView(getActivity());
                    RoundingParams params = RoundingParams.fromCornersRadius(JUtils.dip2px(2));
                    image.getHierarchy().setRoundingParams(params);
                    image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                    image.setImageURI(Uri.parse(banner[i].getImage()));
                    return image;
                }

                @Override
                public int getCount() {
                    return banner.length;
                }
            }
        });
    }
}
