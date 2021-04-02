package bb.toy.api.controller;

import bb.toy.api.domain.Member;
import bb.toy.api.dto.login.RequestLoginDto;
import bb.toy.api.dto.member.RequestMemberDto;
import bb.toy.api.dto.member.ResponseMemberDto;
import bb.toy.api.service.MemberService;
import bb.toy.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class LoginController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // 로그인
    @PostMapping("/api/auth/signIn")
    public HashMap<String, Object> login(@RequestBody RequestLoginDto requestLoginDto) {
        HashMap<String, Object> map = new HashMap<>();
        Member findMember = memberService.findById(Long.parseLong(requestLoginDto.getId()));
        ResponseMemberDto memberDto = new ResponseMemberDto(findMember);

        if (!passwordEncoder.matches(requestLoginDto.getPassword(), findMember.getPassword())) {
            throw new IllegalStateException("정보를 확인해주세요.");
        }

        map.put("userInfo", memberDto);
        map.put("accessToken", jwtTokenProvider.createToken(String.valueOf(findMember.getId()), findMember.getRoles()));

        return map;
    }

    /*@GetMapping("/api/auth/test")
    public void test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("check :" + authentication.getName());
    }*/
}
