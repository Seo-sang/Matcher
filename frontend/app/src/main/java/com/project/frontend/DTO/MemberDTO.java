package com.project.frontend.DTO;

import com.google.gson.annotations.SerializedName;

public class MemberDTO {
    @SerializedName("userId")
    String userId;

    @SerializedName("nickname")
    String nickname;

    @SerializedName("introduction")
    String introduction;

    public MemberDTO(String userId, String nickname, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.introduction = introduction;
    }

    public String getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIntroduction() {
        return introduction;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
