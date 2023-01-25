package project.backend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import project.backend.DTO.ProfileDTO;
import project.backend.data.Chat;
import project.backend.data.Message;
import project.backend.data.User;
import project.backend.data.UserChat;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class Database {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Chat> chats = new ArrayList<>();
    private static Map<String, Chat> userChats = new HashMap<>();
    private static Map<String, ArrayList<Message>> messages = new HashMap<>();

    @PostConstruct
    public void init() {
        users.add(new User("userA", "userA", "userA", "hello, guys"));
    }

    public ProfileDTO getProfileById(String userId) {
        log.info("users size() : {}", users.size());
        for(User user : users) {
            log.info("user.getUserId() : {}", user.getUserId());
            if(user.getUserId() == userId)
                return new ProfileDTO(user.getUserId(), user.getNickname(), user.getIntroduction());
        }
        return null;
    }
}
