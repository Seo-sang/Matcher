package project.backend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
    String userId;
    String nickname;
    String password;
    String introduction;

}
