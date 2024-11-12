package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "profile_image")
public class ProfileImage implements Serializable {
    @Id
    @Column(name = "path", length = 100)
    private String path;
    @ManyToOne
    @JoinColumn(name = "users_email")
    private User users_email;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getUsers_email() {
        return users_email;
    }

    public void setUsers_email(User users_email) {
        this.users_email = users_email;
    }
}
