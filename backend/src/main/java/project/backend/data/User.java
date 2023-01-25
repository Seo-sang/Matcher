package project.backend.data;

import lombok.Getter;
import lombok.Setter;

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
}
