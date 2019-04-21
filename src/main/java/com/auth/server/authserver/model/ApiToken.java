package com.auth.server.authserver.model;

import java.io.Serializable;

public class ApiToken implements Serializable {

    private String token;

    public ApiToken(){

    }

    public ApiToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
