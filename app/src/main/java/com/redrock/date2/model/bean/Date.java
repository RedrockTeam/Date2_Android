package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class Date {
    private String authorFace;
    private String authorName;
    private String title;
    private long date;
    private int type;
    private long postTime;
    private String address;
    private String costType;
    private String memberCount;
    private String praiseCount;
    private String commentCount;

    public Date(String authorFace, String authorName, String title, long date, int type, long postTime, String address, String costType, String memberCount, String praiseCount, String commentCount) {
        this.authorFace = authorFace;
        this.authorName = authorName;
        this.title = title;
        this.date = date;
        this.type = type;
        this.postTime = postTime;
        this.address = address;
        this.costType = costType;
        this.memberCount = memberCount;
        this.praiseCount = praiseCount;
        this.commentCount = commentCount;
    }

    public String getAuthorFace() {
        return authorFace;
    }

    public void setAuthorFace(String authorFace) {
        this.authorFace = authorFace;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getPostTime() {
        return postTime;
    }

    public void setPostTime(long postTime) {
        this.postTime = postTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
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
}
