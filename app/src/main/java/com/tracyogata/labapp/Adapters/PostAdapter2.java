package com.tracyogata.labapp.Adapters;

public class PostAdapter2 {

    private String title, desc;

    public PostAdapter2(String title, String desc, String imageUrl, String username) {
        this.title = title;
        this.desc = desc;

    }

    public PostAdapter2() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
