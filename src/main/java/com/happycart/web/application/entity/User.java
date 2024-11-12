package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "joined_date")
    private LocalDateTime joined_date;
    @Column(name = "varification_code")
    private String varification_code;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.INACTIVE;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_email")
    private Set<Message> from_email = new HashSet<>();
//
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_email")
    private Set<Message> to_email = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_email")
    private Set<ProfileImage> users_email = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email")
    private Set<Product> user_email = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "uses_email")
    private Set<WatchList> uses_email = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(LocalDateTime joined_date) {
        this.joined_date = joined_date;
    }

    public String getVarification_code() {
        return varification_code;
    }

    public void setVarification_code(String varification_code) {
        this.varification_code = varification_code;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Message> getTo_email() {
        return to_email;
    }

    public void setTo_email(Set<Message> to_email) {
        this.to_email = to_email;
    }

    public Set<Message> getFrom_email() {
        return from_email;
    }

    public void setFrom_email(Set<Message> from_email) {
        this.from_email = from_email;
    }

    public Set<ProfileImage> getUsers_email() {
        return users_email;
    }

    public void setUsers_email(Set<ProfileImage> users_email) {
        this.users_email = users_email;
    }

    public Set<Product> getUser_email() {
        return user_email;
    }

    public void setUser_email(Set<Product> user_email) {
        this.user_email = user_email;
    }

    public Set<WatchList> getUses_email() {
        return uses_email;
    }

    public void setUses_email(Set<WatchList> uses_email) {
        this.uses_email = uses_email;
    }
}
