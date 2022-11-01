package com.example.retrofitcodinginflow;

import com.google.gson.annotations.SerializedName;

public class Comment {

    private int id;
    private int postId;
    private String name;
    private String email;

    @SerializedName("body")
    private String text;

    public Comment(int id, int postId, String name, String email) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
