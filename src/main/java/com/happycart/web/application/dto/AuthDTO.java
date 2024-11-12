package com.happycart.web.application.dto;

public class AuthDTO {

    private String password;
    private String email;
    private boolean rememberme;

    public AuthDTO(String email, String password) {
    }

    public AuthDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRememberme() {
        return rememberme;
    }

    public void setRememberme(boolean rememberme) {
        this.rememberme = rememberme;
    }
}
