package com.example.sendsay.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String action = "login";
    private String login;
    private String sablogin;
    private String passwd;

    public AuthRequest(String login, String sablogin, String passwd) {
        this.login = login;
        this.sablogin = sablogin;
        this.passwd = passwd;
    }
}
