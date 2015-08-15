package com.redrock.date2.moudel.date;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.config.Constant;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.flowlayout.BGAFlowLayout;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(FiltratePresenter.class)
public class FiltrateActivity extends BaseActivity<FiltratePresenter> {
    @InjectView(R.id.sort_style)
    BGAFlowLayout sortStyle;
    @InjectView(R.id.sort_user)
    BGAFlowLayout sortUser;
    @InjectView(R.id.sort_cost)
    BGAFlowLayout sortCost;
    @InjectView(R.id.sort_time)
    BGAFlowLayout sortTime;

    private BRViewAdapter mStyleAdapter;
    private BRViewAdapter mUserAdapter;
    private BRViewAdapter mCostAdapter;
    private BRViewAdapter mTimeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity_filtrate);
        ButterKnife.inject(this);
        mStyleAdapter = new BRViewAdapter(this, sortStyle, Constant.SORT_STYLE, index -> getPresenter().setStyle(index));
        mUserAdapter = new BRViewAdapter(this, sortUser, Constant.SORT_USER, index -> getPresenter().setUser(index));
        mCostAdapter = new BRViewAdapter(this, sortCost, Constant.SORT_COST, index -> getPresenter().setCost(index));
        mTimeAdapter = new BRViewAdapter(this, sortTime, Constant.SORT_TIME, index -> getPresenter().setTime(index));
    }

    public void setSortStyle(int index){
        mStyleAdapter.setFocusIndex(index);
    }
    public void setSortUser(int index){
        mUserAdapter.setFocusIndex(index);
    }
    public void setSortCost(int index){
        mCostAdapter.setFocusIndex(index);
    }
    public void setSortTime(int index){
        mTimeAdapter.setFocusIndex(index);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ok,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ok)getPresenter().save();
        return super.onOptionsItemSelected(item);
    }
}
