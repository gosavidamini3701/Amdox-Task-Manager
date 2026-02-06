package com.TaskManageMent0.DTO;

public class AuthResponseDTO {

    public String token ;
    public String message ;

    public AuthResponseDTO(){}

    public AuthResponseDTO(String token , String message ){

        this.token = token ;
        this.message = message ;


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
