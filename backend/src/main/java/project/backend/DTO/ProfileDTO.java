package project.backend.DTO;

public class ProfileDTO {
    String userId;
    String nickname;
    String introduction;

    public ProfileDTO(String userId, String nickname, String introduction) {
        this.userId = userId;
        this.nickname = nickname;
        this.introduction = introduction;
    }

}
