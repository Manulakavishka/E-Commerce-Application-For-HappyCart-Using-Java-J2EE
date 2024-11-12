package com.happycart.web.application.dto;

import com.happycart.web.application.entity.Gender;
import com.happycart.web.application.entity.Status;

import java.time.LocalDateTime;

public class UpdateDTO extends AuthDTO {
    private String fname;
    private String lname;
    private Gender gender;
    private Status status;
    private String mobile;
    private String varification_code;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVarification_code() {
        return varification_code;
    }

    public void setVarification_code(String varification_code) {
        this.varification_code = varification_code;
    }
}
