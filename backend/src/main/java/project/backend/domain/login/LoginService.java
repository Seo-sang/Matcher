package project.backend.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.backend.DTO.MemberDTO;
import project.backend.Database;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final Database database;

    public MemberDTO login(String userId, String password) {
        return database.getMemberById(userId);
    }
}
