package com.jaymin.TaskDemo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.persistence.Id;


public class Owner {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("picture")
    private String picture;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dateOfBirth")
    private String DOB;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("registerDate")
    private String registerDate;

    @JsonProperty("updatedDate")
    private String updateDate;
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPicture() {
        return picture;
    }
}
