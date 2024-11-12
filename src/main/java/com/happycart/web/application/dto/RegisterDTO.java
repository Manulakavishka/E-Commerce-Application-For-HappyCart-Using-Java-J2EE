package com.happycart.web.application.dto;

import com.happycart.web.application.entity.Gender;
import com.happycart.web.application.entity.Status;

import java.time.LocalDateTime;

public class RegisterDTO extends AuthDTO {

    private String fname;
    private String lname;
    private String repassword;
    private Gender gender;
    private Status status;
    private String mobile;
    private String varification_code;
    private boolean agreeTerms;

    private LocalDateTime joined_date;

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

    public LocalDateTime getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(LocalDateTime joined_date) {
        this.joined_date = joined_date;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public boolean isAgreeTerms() {
        return agreeTerms;
    }

    public void setAgreeTerms(boolean agreeTerms) {
        this.agreeTerms = agreeTerms;
    }
}
