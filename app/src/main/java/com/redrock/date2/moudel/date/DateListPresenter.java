package com.redrock.date2.moudel.date;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Banner;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class DateListPresenter extends BeamListFragmentPresenter<DateListFragment,Date> {
    private int page = 0;
    private int type;

    @Override
    protected void onCreate(DateListFragment view,Bundle savedState) {
        super.onCreate(view,savedState);
        type = getView().getArguments().getInt("id");
        onRefresh();
        if(type == 0){
            DateModel.getInstance().getBanner(new DataCallback<Banner[]>() {
                @Override
                public void success(String info, Banner[] data) {
                    addBanner(data);
                }
            });
        }
    }


    private void addBanner(Banner[] banner){
        getAdapter().addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup viewGroup) {
                View view = LayoutInflater.from(getView().getActivity()).inflate(R.layout.date_banner, viewGroup, false);
                RollPagerView vp = (RollPagerView) view.findViewById(R.id.view_pager);
                vp.setAdapter(new BannerAdapter());

                return view;
            }

            @Override
            public void onBindView(View view) {

            }

            class BannerAdapter extends StaticPagerAdapter {

                @Override
                public View getView(ViewGroup viewGroup, int i) {
                    SimpleDraweeView image = new SimpleDraweeView(DateListPresenter.this.getView().getActivity());
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

    @Override
    public void onRefresh() {
        DateModel.getInstance().getDate(0,type ,new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getAdapter().clear();
                getAdapter().addAll(data);
                page = 1;
            }

            @Override
            public void error(String errorInfo) {
                getView().showError();
            }
        });
    }

    @Override
    public void onLoadMore() {
        DateModel.getInstance().getDate(page,type ,new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getAdapter().addAll(data);
                page ++;
            }

            @Override
            public void error(String errorInfo) {
                getAdapter().pauseMore();
            }
        });
    }

}
