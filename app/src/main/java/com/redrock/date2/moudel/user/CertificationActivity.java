package com.redrock.date2.moudel.user;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.redrock.date2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(CertificationPresenter.class)
public class CertificationActivity extends BeamBaseActivity<CertificationPresenter> {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.card_a)
    ImageView cardA;
    @InjectView(R.id.card_b)
    ImageView cardB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_certification);
        ButterKnife.inject(this);
        cardA.setOnClickListener(v -> getPresenter().startCameraA());
        cardB.setOnClickListener(v->getPresenter().startCameraB());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send,menu);
        return true;
    }

    public void setPhotoA(Bitmap img){
        cardA.setImageBitmap(img);
    }
    public void setPhotoB(Bitmap img){
        cardB.setImageBitmap(img);
    }
}
