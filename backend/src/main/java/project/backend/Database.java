package project.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import project.backend.DTO.MemberDTO;
import project.backend.DTO.UserDTO;
import project.backend.domain.data.Chat;
import project.backend.domain.data.Message;
import project.backend.domain.data.User;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class Database {
    /**
     * <userID, User>
     * <chatId, Chat>
     * <userId, Chat>
     * <chatId, Array>
     */
    private static Map<String, User> users = new ConcurrentHashMap<>();
    private static Map<String, Chat> chats = new ConcurrentHashMap<>();
    private static Map<String, Chat> userChats = new ConcurrentHashMap<>();
    private static Map<String, ArrayList<Message>> messages = new HashMap<>();

    @PostConstruct
    public void init() {
        users.put("userA", new User("userA", "userA", "userA", "hello, userA"));
        users.put("userB", new User("userB", "userB", "userB", "hello, userB"));
        users.put("userC", new User("userC", "userC", "userC", "hello, userC"));
    }

    public boolean save(UserDTO userDTO) {
        //회원이 있는지 확인
        Optional<User> result = findAll().stream()
                .filter(user -> user.getUserId().equals(userDTO.getUserId()))
                .findAny();

        if(result.isPresent()) { //회원이 존재하는 경우 false 리턴
            return false;
        }
        else { //없는 경우 새로 생성
            users.put(userDTO.getUserId(), new User(userDTO));
            return true;
        }
    }

    public MemberDTO getMemberById(String userId) {
        Optional<User> result = findAll().stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();

        if(result.isEmpty()) {
            return null;
        }
        else {
            return new MemberDTO(result.get());
        }
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
