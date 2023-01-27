package project.backend.domain.data;

import lombok.Data;

@Data
public class Member {
    String userId;
    String nickname;
    String introduction;

    public Member(String userId, String nickname, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.introduction = introduction;
    }

    public Member(User user) {
        this.userId = user.getUserId();
        this.nickname = user.getNickname();
        this.introduction = user.getIntroduction();
    }
}
