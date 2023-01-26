package com.project.frontend.DTO;


import com.google.gson.annotations.SerializedName;

public class LoginDTO {
    @SerializedName("userId")
    private String userId;

    @SerializedName("password")
    private String password;

    public LoginDTO(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
