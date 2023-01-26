package project.backend.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.backend.DTO.MemberDTO;
import project.backend.DTO.UserDTO;
import project.backend.Database;
import project.backend.domain.data.User;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final Database database;

    /**
     * 회원가입
     */
    @PostMapping("/add")
    public String signUp(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        boolean result = database.save(userDTO);

        if(result == true) {
            response.setStatus(HttpServletResponse.SC_OK);
            return "ok";
        }
        else {
            response.setStatus(401);
            return "User ID already existed";
        }
    }

    /**
     * 프로필 찾기
     */
    @GetMapping("/{userId}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable String userId) {
        log.info("userId : {}", userId);
        //userID로 검색
        MemberDTO member = database.getMemberById(userId);
        //만약 검색한 ID가 없는 경우 404에러

        if(member == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }

    }

}
