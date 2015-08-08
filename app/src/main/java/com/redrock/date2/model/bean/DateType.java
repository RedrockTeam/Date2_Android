package com.redrock.date2.model.bean;

import java.io.Serializable;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DateType implements Serializable{
    private String name;
    private int id;

    public DateType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
