package com.redrock.date2.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.beam.Beam;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.http.RequestManager;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.redrock.date2.BuildConfig;
import com.redrock.date2.R;
import com.redrock.date2.config.Dir;
import com.redrock.date2.utils.DataCleaner;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        JUtils.initialize(this);
        JUtils.setDebug(BuildConfig.DEBUG, "DateLog");
        JFileManager.getInstance().init(this, Dir.values());
        DataCleaner.Update(90);//清除过期数据

        Fresco.initialize(this);
        RequestManager.getInstance().init(this);
        RequestManager.getInstance().setDebugMode(BuildConfig.DEBUG, "DateNet");
        Beam.init(this);
        Beam.registerActivityLifetCyclerDelegate(ActivityDelegate.class);
        ListConfig.setDefaultListConfig(
                new ListConfig().
                        setRefreshAble(true).
                        setContainerLayoutRes(R.layout.activity_recyclerview));
    }
}
