package com.tico.tico.entities;

import java.util.Date;
import java.util.List;

public class Community {
    private String community_user;
    private String community_context;
    private List<Object> community_images;
    private int community_praise_count;
    private String community_title;
    private Date community_time;

    public String getCommunity_user() {
        return community_user;
    }

    public void setCommunity_user(String community_user) {
        this.community_user = community_user;
    }

    public String getCommunity_context() {
        return community_context;
    }

    public void setCommunity_context(String community_context) {
        this.community_context = community_context;
    }

    public List<Object> getCommunity_images() {
        return community_images;
    }

    public void setCommunity_images(List<Object> community_images) {
        this.community_images = community_images;
    }

    public int getCommunity_praise_count() {
        return community_praise_count;
    }

    public void setCommunity_praise_count(int community_praise_count) {
        this.community_praise_count = community_praise_count;
    }

    public String getCommunity_title() {
        return community_title;
    }

    public void setCommunity_title(String community_title) {
        this.community_title = community_title;
    }

    public Date getCommunity_time() {
        return community_time;
    }

    public void setCommunity_time(Date community_time) {
        this.community_time = community_time;
    }
}
