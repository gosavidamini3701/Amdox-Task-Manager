package com.TaskManageMent0.DTO;


import com.TaskManageMent0.Entity.UserAuth;

public class AuthResponseDTO {

    public String token ;
    public UserAuth user ;
    public String message ;

    public AuthResponseDTO(){}

    public AuthResponseDTO(String token, UserAuth user, String message) {
        this.token = token;
        this.user = user;
        this.message = message;
    }

    public UserAuth getUser() {
        return user;
    }

    public void setUser(UserAuth user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }






}
