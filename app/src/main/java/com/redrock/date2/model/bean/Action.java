package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class Action {
    @SerializedName("discover_picture")
    private String image;
    @SerializedName("discover_title")
    private String title;
    @SerializedName("discover_caption")
    private String tag;
    @SerializedName("apply_num")
    private String memberCount;
    @SerializedName("discover_praise")
    private String praiseCount;
    @SerializedName("comment_num")
    private String commentCount;
    @SerializedName("discover_status")
    private int status;
    @SerializedName("praise_status")
    private int praiseStatus;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }

    public String getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(String praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Action(String image, String title, String tag, String memberCount, String praiseCount, String commentCount) {

        this.image = image;
        this.title = title;
        this.tag = tag;
        this.memberCount = memberCount;
        this.praiseCount = praiseCount;
        this.commentCount = commentCount;
    }
}
