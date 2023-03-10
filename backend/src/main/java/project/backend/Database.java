package project.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import project.backend.DTO.FriendDTO;
import project.backend.DTO.MemberDTO;
import project.backend.DTO.UserDTO;
import project.backend.domain.data.Chat;
import project.backend.domain.data.Member;
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
     * <userID, Member>
     * <chatId, Chat>
     * <userId, Chat>
     * <chatId, Array>
     */
    private static Map<String, User> users = new ConcurrentHashMap<>();
    private static Map<String, List<Member>> friends = new ConcurrentHashMap<>();
    private static Map<String, Chat> chats = new ConcurrentHashMap<>();
    private static Map<String, Chat> userChats = new ConcurrentHashMap<>();
    private static Map<String, ArrayList<Message>> messages = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        users.put("userA", new User("userA", "userA", "userA", "hello, userA"));
        users.put("userB", new User("userB", "userB", "userB", "hello, userB"));
        users.put("userC", new User("userC", "userC", "userC", "hello, userC"));

        friends.put("userA", new ArrayList<>());
        friends.get("userA").add(new Member("friendA", "friendA", "hello, friendA"));
        friends.get("userA").add(new Member("friendB", "friendB", "hello, friendB"));
        friends.get("userA").add(new Member("friendC", "friendC", "hello, friendC"));
        friends.get("userA").add(new Member("friendD", "friendD", "hello, friendD"));
    }

    public FriendDTO getFriends(String userId) {
        List<Member> members = friends.get(userId);
        if(members == null) return null;
        List<MemberDTO> ret = new ArrayList<>();
        for (Member member : members) {
            ret.add(new MemberDTO(member));
        }
        return new FriendDTO(ret);
    }

    public boolean save(UserDTO userDTO) {
        //????????? ????????? ??????
        Optional<User> result = findAll().stream()
                .filter(user -> user.getUserId().equals(userDTO.getUserId()))
                .findAny();
        if(result.isPresent()) { //????????? ???????????? ?????? false ??????
            return false;
        }
        else { //?????? ?????? ?????? ??????
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
