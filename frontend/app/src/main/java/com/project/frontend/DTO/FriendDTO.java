package com.project.frontend.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendDTO {
    @SerializedName("friends")
    private List<MemberDTO> friends;

    public FriendDTO(List<MemberDTO> friends) {
        this.friends = friends;
    }

    public List<MemberDTO> getFriends() {
        return friends;
    }
}
