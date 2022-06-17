package com.jaymin.TaskDemo.Entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@Builder
public class Owner {

    @Id
    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "owner_first_name")
    private String firstName;

    @Column(name = "owner_last_name")
    private String lastName;

    @Column(name = "owner_img")
    private String owner_img;

    public Owner() {
    }

    public Owner(String ownerId, String firstName, String lastName, String owner_img) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.owner_img = owner_img;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOwner_img() {
        return owner_img;
    }

    public void setOwner_img(String owner_img) {
        this.owner_img = owner_img;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", owner_img='" + owner_img + '\'' +
                '}';
    }
}
