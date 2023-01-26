package project.backend.domain.data;

import lombok.Getter;
import lombok.Setter;
import project.backend.DTO.UserDTO;

@Getter @Setter
public class User {
    String userId;
    String nickname;
    String password;
    String introduction;

    public User(String userId, String nickname, String password, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.introduction = introduction;
    }

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.nickname = userDTO.getNickname();
        this.password = userDTO.getPassword();
        this.introduction = userDTO.getIntroduction();
    }
}
