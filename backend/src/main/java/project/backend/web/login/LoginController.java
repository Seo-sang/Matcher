package project.backend.web.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.backend.DTO.LoginDTO;
import project.backend.DTO.MemberDTO;
import project.backend.domain.login.LoginService;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    //로그인
    @PostMapping("/login")
    public ResponseEntity<MemberDTO> login(@RequestBody LoginDTO loginDTO) {
        MemberDTO member = loginService.login(loginDTO.getUserId(), loginDTO.getPassword());

        log.info("member : {}", member);
        return (member == null)
                ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(member, HttpStatus.OK);
    }

    //로그아웃
    @PostMapping("/logout")
    public void logout(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
