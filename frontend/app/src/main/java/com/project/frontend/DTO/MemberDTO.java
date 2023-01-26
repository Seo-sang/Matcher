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

}
