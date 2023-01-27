package project.backend.DTO;

import lombok.Data;
import project.backend.domain.data.Member;
import project.backend.domain.data.User;

@Data
public class MemberDTO {
    String userId;
    String nickname;
    String introduction;

    public MemberDTO(String userId, String nickname, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.introduction = introduction;
    }

    public MemberDTO(User user) {
        this.userId = user.getUserId();
        this.nickname = user.getNickname();
        this.introduction = user.getIntroduction();
    }

    public MemberDTO(Member member) {
        this.userId = member.getUserId();
        this.nickname = member.getNickname();
        this.introduction = member.getIntroduction();
    }
}
