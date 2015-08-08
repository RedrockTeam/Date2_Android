package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class Banner {
    private String image;
    private String url;

    public Banner(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
