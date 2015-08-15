package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class Comment {
    private String authorFace;
    private String authorName;
    private int authorGender;
    private int authorAge;
    private boolean isCertification;

    public Comment(String authorFace, String authorName, int authorGender, int authorAge, boolean isCertification, String content, long time) {
        this.authorFace = authorFace;
        this.authorName = authorName;
        this.authorGender = authorGender;
        this.authorAge = authorAge;
        this.isCertification = isCertification;
        this.content = content;
        this.time = time;
    }

    private String content;
    private long time;


    public int getAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(int authorGender) {
        this.authorGender = authorGender;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public boolean isCertification() {
        return isCertification;
    }

    public void setIsCertification(boolean isCertification) {
        this.isCertification = isCertification;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
