package com.project.frontend.ui.item;

import com.google.gson.annotations.SerializedName;
import com.project.frontend.DTO.MemberDTO;

public class ListViewItem {
    String userId;

    String nickname;

    String introduction;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public ListViewItem(String userId, String nickname, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.introduction = introduction;
    }

    public ListViewItem(MemberDTO memberDTO) {
        this.userId = memberDTO.getUserId();
        this.nickname = memberDTO.getNickname();
        this.introduction = memberDTO.getIntroduction();
    }
}
