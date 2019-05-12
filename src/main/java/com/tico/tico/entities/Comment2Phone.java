package com.tico.tico.entities;

import java.util.Date;

public class Comment2Phone {
    private String comment_phone_commentor;//评论者
    private String comment_phone_commentby;//被评论的产品
    private Date comment_phone_time;
    private String comment_phone_context;
    private String comment_phone_replyto_name;//回复给的人的名字，形式：“@_name”
    private double comment_phone_price_mark;//性价比评分 0-5
    private double comment_phone_screen_mark;
    private double comment_phone_fluency_mark;
    private double comment_phone_battery_mark;
    private double comment_phone_camera_mark;

    public Comment2Phone(String comment_phone_commentor, String comment_phone_commentby, String comment_phone_context, double comment_phone_price_mark, double comment_phone_screen_mark, double comment_phone_fluency_mark, double comment_phone_battery_mark, double comment_phone_camera_mark) {
        this.comment_phone_commentor = comment_phone_commentor;
        this.comment_phone_commentby = comment_phone_commentby;
        this.comment_phone_context = comment_phone_context;
        this.comment_phone_price_mark = comment_phone_price_mark;
        this.comment_phone_screen_mark = comment_phone_screen_mark;
        this.comment_phone_fluency_mark = comment_phone_fluency_mark;
        this.comment_phone_battery_mark = comment_phone_battery_mark;
        this.comment_phone_camera_mark = comment_phone_camera_mark;
    }

    public String getComment_phone_commentor() {
        return comment_phone_commentor;
    }

    public void setComment_phone_commentor(String comment_phone_commentor) {
        this.comment_phone_commentor = comment_phone_commentor;
    }

    public String getComment_phone_commentby() {
        return comment_phone_commentby;
    }

    public void setComment_phone_commentby(String comment_phone_commentby) {
        this.comment_phone_commentby = comment_phone_commentby;
    }

    public Date getComment_phone_time() {
        return comment_phone_time;
    }

    public void setComment_phone_time(Date comment_phone_time) {
        this.comment_phone_time = comment_phone_time;
    }

    public String getComment_phone_context() {
        return comment_phone_context;
    }

    public void setComment_phone_context(String comment_phone_context) {
        this.comment_phone_context = comment_phone_context;
    }

    public String getComment_phone_replyto_name() {
        return comment_phone_replyto_name;
    }

    public void setComment_phone_replyto_name(String comment_phone_replyto_name) {
        this.comment_phone_replyto_name = comment_phone_replyto_name;
    }

    public double getComment_phone_price_mark() {
        return comment_phone_price_mark;
    }

    public void setComment_phone_price_mark(double comment_phone_price_mark) {
        this.comment_phone_price_mark = comment_phone_price_mark;
    }

    public double getComment_phone_screen_mark() {
        return comment_phone_screen_mark;
    }

    public void setComment_phone_screen_mark(double comment_phone_screen_mark) {
        this.comment_phone_screen_mark = comment_phone_screen_mark;
    }

    public double getComment_phone_fluency_mark() {
        return comment_phone_fluency_mark;
    }

    public void setComment_phone_fluency_mark(double comment_phone_fluency_mark) {
        this.comment_phone_fluency_mark = comment_phone_fluency_mark;
    }

    public double getComment_phone_battery_mark() {
        return comment_phone_battery_mark;
    }

    public void setComment_phone_battery_mark(double comment_phone_battery_mark) {
        this.comment_phone_battery_mark = comment_phone_battery_mark;
    }

    public double getComment_phone_camera_mark() {
        return comment_phone_camera_mark;
    }

    public void setComment_phone_camera_mark(double comment_phone_camera_mark) {
        this.comment_phone_camera_mark = comment_phone_camera_mark;
    }
}
