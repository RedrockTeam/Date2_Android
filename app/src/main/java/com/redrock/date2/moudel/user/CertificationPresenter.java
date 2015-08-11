package com.redrock.date2.moudel.user;

import android.net.Uri;
import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.library.imageprovider.ImageProvider;
import com.jude.library.imageprovider.OnImageSelectListener;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class CertificationPresenter extends Presenter<CertificationActivity> {
    private ImageProvider mProvider;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        mProvider = new ImageProvider(getView());
    }

    public void startCameraA(){
        mProvider.getImageFromCamera(new OnImageSelectListener() {
            @Override
            public void onImageSelect() {

            }

            @Override
            public void onImageLoaded(Uri uri) {
                getView().setPhotoA(uri);
            }

            @Override
            public void onError() {

            }
        });
    }
    public void startCameraB(){
        mProvider.getImageFromCamera(new OnImageSelectListener() {
            @Override
            public void onImageSelect() {

            }

            @Override
            public void onImageLoaded(Uri uri) {
                getView().setPhotoB(uri);
            }

            @Override
            public void onError() {

            }
        });
    }

}
