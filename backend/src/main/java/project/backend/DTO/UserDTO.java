package project.backend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
    private String userId;
    private String nickname;
    private String password;
    private String introduction;
}
