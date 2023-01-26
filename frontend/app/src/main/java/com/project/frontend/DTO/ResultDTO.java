package com.project.frontend.DTO;

import com.google.gson.annotations.SerializedName;

public class ResultDTO {
    @SerializedName("message")
    private String message;

    public ResultDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
