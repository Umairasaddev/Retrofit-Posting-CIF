package com.example.retrofitcodinginflow;

import com.google.gson.annotations.SerializedName;


public class Post {

    @SerializedName("fact")

    private String fact;
    @SerializedName("length")

    private Integer length;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}


    //1
    //we will initiaalize these json objects
  //  private int userId;



    //private int id;

  //  private String text;

   // @SerializedName("body")//now our Json parser know that text string  is the body value of Json
  //  private String title;




/*
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;

  */


