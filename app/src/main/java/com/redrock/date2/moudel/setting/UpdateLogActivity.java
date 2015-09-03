package com.redrock.date2.moudel.setting;

import android.os.Bundle;
import android.widget.TextView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.http.RequestListener;
import com.jude.http.RequestManager;
import com.redrock.date2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(UpdateLogPresenter.class)
public class UpdateLogActivity extends BeamBaseActivity<UpdateLogPresenter> {

    @InjectView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_updatelog);
        ButterKnife.inject(this);
        getExpansion().showProgressDialog("加载中");
        RequestManager.getInstance().get("https://raw.githubusercontent.com/RedrockTeam/Date2_Android/master/updateLog.txt", new RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String s) {
                getExpansion().dismissProgressDialog();
                text.setText(s);
            }

            @Override
            public void onError(String s) {
                getExpansion().dismissProgressDialog();
            }
        });
    }
}
