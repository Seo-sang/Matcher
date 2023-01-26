package project.backend.domain.data;

import lombok.Getter;

@Getter
public class UserChat {
    String userId;
    String chatId;

    public UserChat(String userId, String chatId) {
        this.userId = userId;
        this.chatId = chatId;
    }
}
