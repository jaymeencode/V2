package com.jaymin.TaskDemo.Entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
@Builder
public class Users {
    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_message")
    private String userMessage;

//    @Column(name = "owner_id")
    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "owner_id")
    private Owner ownerId;

    @Column(name = "post_id")
    private String postId;

    @Column(name = "publish_date")
    private Date publishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Users(String id, String userMessage, Owner ownerId, String postId, Date publishDate) {
        this.id = id;
        this.userMessage = userMessage;
        this.ownerId = ownerId;
        this.postId = postId;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userMessage='" + userMessage + '\'' +
                ", ownerId=" + ownerId +
                ", postId='" + postId + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    public Users() {
    }


}
