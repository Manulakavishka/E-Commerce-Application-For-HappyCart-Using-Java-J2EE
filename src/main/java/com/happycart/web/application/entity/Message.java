package com.happycart.web.application.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_email")
    private User from_email;

    @ManyToOne
    @JoinColumn(name = "to_email")
    private User to_email;
    @Column(name = "content", length = 500)
    private String content;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.ACTIVE;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFrom_email() {
        return from_email;
    }

    public void setFrom_email(User from_email) {
        this.from_email = from_email;
    }

    public User getTo_email() {
        return to_email;
    }

    public void setTo_email(User to_email) {
        this.to_email = to_email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
