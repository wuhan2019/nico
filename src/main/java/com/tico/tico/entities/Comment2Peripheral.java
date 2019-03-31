package com.tico.tico.entities;

import java.util.Date;

public class Comment2Peripheral {
    private String comment_peripheral_commentor;
    private String comment_peripheral_commentby;
    private Date comment_peripheral_time;
    private String comment_peripheral_context;
    private String comment_peripheral_replyto_name;
    private int comment_peripheral_mark;

    public String getComment_peripheral_commentor() {
        return comment_peripheral_commentor;
    }

    public void setComment_peripheral_commentor(String comment_peripheral_commentor) {
        this.comment_peripheral_commentor = comment_peripheral_commentor;
    }

    public String getComment_peripheral_commentby() {
        return comment_peripheral_commentby;
    }

    public void setComment_peripheral_commentby(String comment_peripheral_commentby) {
        this.comment_peripheral_commentby = comment_peripheral_commentby;
    }

    public Date getComment_peripheral_time() {
        return comment_peripheral_time;
    }

    public void setComment_peripheral_time(Date comment_peripheral_time) {
        this.comment_peripheral_time = comment_peripheral_time;
    }

    public String getComment_peripheral_context() {
        return comment_peripheral_context;
    }

    public void setComment_peripheral_context(String comment_peripheral_context) {
        this.comment_peripheral_context = comment_peripheral_context;
    }

    public String getComment_peripheral_replyto_name() {
        return comment_peripheral_replyto_name;
    }

    public void setComment_peripheral_replyto_name(String comment_peripheral_replyto_name) {
        this.comment_peripheral_replyto_name = comment_peripheral_replyto_name;
    }

    public int getComment_peripheral_mark() {
        return comment_peripheral_mark;
    }

    public void setComment_peripheral_mark(int comment_peripheral_mark) {
        this.comment_peripheral_mark = comment_peripheral_mark;
    }
}
