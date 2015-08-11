package com.redrock.date2.model.bean;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class User {
    private String id;
    private String face;
    private String name;
    private String sign;
    private String attentionCount;
    private String fansCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String face, String name, String sign, String attentionCount, String fansCount) {

        this.id = id;
        this.face = face;
        this.name = name;
        this.sign = sign;
        this.attentionCount = attentionCount;
        this.fansCount = fansCount;
    }
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getFansCount() {
        return fansCount;
    }

    public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
    }
}
