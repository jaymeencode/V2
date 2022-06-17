package com.jaymin.TaskDemo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;

public class DataClass {
    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String Message;
    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("post")
    private String post;
    @JsonProperty("publishDate")
    private Date pubDate;

    public String getId() {
        return id;
    }

    public String getMessage() {
        return Message;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getPost() {
        return post;
    }

    public Date getPubDate() {
        return pubDate;
    }
}
