package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class Comment {
    private String authorFace;
    private String authorName;
    private String content;
    private long time;

    public Comment(String authorFace, String authorName, String content, long time) {
        this.authorFace = authorFace;
        this.authorName = authorName;
        this.content = content;
        this.time = time;
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
