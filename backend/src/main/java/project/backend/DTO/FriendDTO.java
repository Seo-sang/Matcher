package project.backend.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FriendDTO {

    private List<MemberDTO> friends;

    public FriendDTO(List<MemberDTO> friends) {
        this.friends = friends;
    }
}
