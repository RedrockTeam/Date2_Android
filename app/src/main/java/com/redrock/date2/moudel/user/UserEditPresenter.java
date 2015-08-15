package com.redrock.date2.moudel.user;

import android.content.Intent;
import android.net.Uri;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.library.imageprovider.ImageProvider;
import com.jude.library.imageprovider.OnImageSelectListener;
import com.jude.utils.JUtils;
import com.redrock.date2.model.RemoteFileModel;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.model.callback.DataCallback;
import com.redrock.date2.model.callback.StatusCallback;

import java.io.File;

/**
 * Created by Mr.Jude on 2015/8/15.
 */
public class UserEditPresenter extends Presenter<UserEditActivity> {
    private ImageProvider provider;
    private Uri faceUri;
    private String face;
    private String name;
    private String sign;
    private String tag;

    @Override
    protected void onCreateView(UserEditActivity view) {
        super.onCreateView(view);
        provider = new ImageProvider(getView());
        UserModel.getInstance().getUserDetail(UserModel.getInstance().getAccount().getId(), new DataCallback<UserDetail>() {
            @Override
            public void success(String info, UserDetail data) {
                getView().setUser(data);
                face = data.getFace();
                name = data.getName();
                sign = data.getSign();
                tag = data.getTag();
            }
        });
    }

    public void editFace(int style){
        OnImageSelectListener listener = new OnImageSelectListener() {
            @Override
            public void onImageSelect() {
                getView().showProgress("加载中");
            }

            @Override
            public void onImageLoaded(Uri uri) {
                getView().dismissProgress();
                //开始裁剪
                provider.corpImage(uri, 300, 300, new OnImageSelectListener() {
                    @Override
                    public void onImageSelect() {
                    }

                    @Override
                    public void onImageLoaded(Uri uri) {
                        faceUri = uri;
                        getView().setUserFace(faceUri);
                    }

                    @Override
                    public void onError() {

                    }
                });
            }

            @Override
            public void onError() {
                getView().dismissProgress();
            }
        };
        switch (style){
            case 0:
                provider.getImageFromCamera(listener);
                break;
            case 1:
                provider.getImageFromAlbum(listener);
                break;
            case 2:
                provider.getImageFromNet(listener);
                break;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public void submit(){
        RemoteFileModel.getInstance().putImage(new File(faceUri.getPath()), new RemoteFileModel.UploadImageListener() {
            @Override
            public void onComplete(RemoteFileModel.SizeImage path) {
                UserModel.getInstance().modifyFace(path.getOriginalImage(), new StatusCallback() {
                    @Override
                    public void success(String info) {
                        JUtils.Toast("上传成功");

                    }

                    @Override
                    public void result(int status, String info) {
                        getView().dismissProgress();
                    }
                });
            }

            @Override
            public void onError() {
                JUtils.Toast("上传失败");
                getView().dismissProgress();
            }
        });
    }


    @Override
    protected void onResult(int requestCode, int resultCode, Intent data) {
        super.onResult(requestCode, resultCode, data);
        provider.onActivityResult(requestCode, resultCode, data);
    }
}
