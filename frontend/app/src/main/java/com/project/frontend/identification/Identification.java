package com.project.frontend.identification;

import com.project.frontend.DTO.MemberDTO;

public class Identification {

    private static Identification identification = new Identification();

    private String userId;

    private String nickname;

    private String introduction;

    public static Identification getInstance() {
        return identification;
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

    public void init(MemberDTO memberDTO) {
        this.userId = memberDTO.getUserId();
        this.nickname = memberDTO.getNickname();
        this.introduction = memberDTO.getIntroduction();
    }
}
