package com.project.frontend.DTO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class UserDTO {
    @SerializedName("userId")
    private String userId;

    @SerializedName("password")
    private String password;

    @SerializedName("nickname")
    private String nickname;

    @Nullable
    @SerializedName("introduction")
    private String introduction;

    public UserDTO(String userId, String password, String nickname, @Nullable String introduction) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
