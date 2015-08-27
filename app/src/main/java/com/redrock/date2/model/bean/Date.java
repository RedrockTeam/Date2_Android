package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class Date {
    @SerializedName("date_id")
    private String id;
    @SerializedName("avatar")
    private String authorFace;
    @SerializedName("nickname")
    private String authorName;
    @SerializedName("gender")
    private int authorGender;
    @SerializedName("grade")
    private int authorAge;
    @SerializedName("role_id")
    private int authorRole;
    @SerializedName("title")
    private String title;
    @SerializedName("time")
    private long date;
    @SerializedName("date_type")
    private int type;
    @SerializedName("created_time")
    private long postTime;
    @SerializedName("date_place")
    private String address;
    @SerializedName("cost_type")
    private String costType;
    @SerializedName("apply_num")
    private String memberCount;
    @SerializedName("praise")
    private String praiseCount;
    @SerializedName("comment_num")
    private String commentCount;
    @SerializedName("praised")
    private boolean praised;

    public Date(String id, String authorFace, String authorName, int authorGender, int authorAge, int authorRole, String title, long date, int type, long postTime, String address, String costType, String memberCount, String praiseCount, String commentCount, boolean praised) {
        this.id = id;
        this.authorFace = authorFace;
        this.authorName = authorName;
        this.authorGender = authorGender;
        this.authorAge = authorAge;
        this.authorRole = authorRole;
        this.title = title;
        this.date = date;
        this.type = type;
        this.postTime = postTime;
        this.address = address;
        this.costType = costType;
        this.memberCount = memberCount;
        this.praiseCount = praiseCount;
        this.commentCount = commentCount;
        this.praised = praised;
    }

    public boolean isPraised() {
        return praised;
    }

    public void setPraised(boolean praised) {
        this.praised = praised;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAuthorRole() {
        return authorRole;
    }

    public void setAuthorRole(int authorRole) {
        this.authorRole = authorRole;
    }
    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
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


    public int getAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(int authorGender) {
        this.authorGender = authorGender;
    }


}
