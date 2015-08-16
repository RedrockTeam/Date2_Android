package com.redrock.date2.utils;

import com.jude.utils.JTimeTransform;

/**
 * Created by Mr.Jude on 2015/8/15.
 */
public class YearAnalysis {
    public static String analysis(int year){
        int delta = new JTimeTransform().getYear()-year;
        if (new JTimeTransform().getMonth()<7)delta-=1;
        if (delta < 0)return "小屁孩";
        switch (delta){
            case 0:
                return "大一";
            case 1:
                return "大二";
            case 2:
                return "大三";
            case 3:
                return "大四";
        }
        return year+"级";
    }
}
