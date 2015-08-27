package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class User implements Serializable{
    @SerializedName("uid")
    private String id;
    @SerializedName("avatar")
    private String face;
    @SerializedName("nickname")
    private String name;
    @SerializedName("signature")
    private String sign;
    @SerializedName("gender")
    private int gender;
    @SerializedName("a")
    private int age;
    @SerializedName("role_id")
    private int role;


    public User(String id, String face, String name, String sign, int gender, int age, int role) {
        this.id = id;
        this.face = face;
        this.name = name;
        this.sign = sign;
        this.gender = gender;
        this.age = age;
        this.role = role;
    }

    public int getGender() {

        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int isCertification() {
        return role;
    }

    public void setIsCertification(int role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
