package com.tracyogata.labapp.Models;

import com.google.firebase.database.ServerValue;

public class Post {
    private String title;
    private String description;
    private Object timeStamp;
    private String postKey;

    public Post(String title, String description){
        this.title = title;
        this.description = description;
        this.timeStamp = ServerValue.TIMESTAMP;
    }


    public Post() {
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
