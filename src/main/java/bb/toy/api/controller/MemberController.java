package bb.toy.api.controller;


import bb.toy.api.domain.Member;
import bb.toy.api.dto.member.RequestMemberDto;
import bb.toy.api.dto.member.ResponseMemberDto;
import bb.toy.api.dto.member.ResultMemberDto;
import bb.toy.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 등록
    @PostMapping("/api/member")
    public String saveMember(@RequestBody @Valid RequestMemberDto requestMemberDto) {
        String id = memberService.save(requestMemberDto);

        return id;
    }

    // 1건 조회
    @GetMapping("/api/member/{id}")
    public ResponseMemberDto findMember(@PathVariable("id") String id) {
        Member member = memberService.findById(id);

        ResponseMemberDto memberDto = new ResponseMemberDto(member);

        return memberDto;
    }

    // 전체 조회
    @GetMapping("/api/member/all")
    public ResultMemberDto findMembers() {
        List<Member> members = memberService.findAll();
        List<ResponseMemberDto> dtos = members.stream()
                                                    .map(o -> new ResponseMemberDto(o))
                                                    .collect(Collectors.toList());

        return new ResultMemberDto(dtos.size(), dtos);
    }

    // 수정
    @PutMapping("/api/member")
    public void updateMember(@RequestBody @Valid RequestMemberDto requestMemberDto) {
        memberService.update(requestMemberDto);
    }

    // 삭제
    @DeleteMapping("/api/member/{id}")
    public void deleteMember(@PathVariable("id") String id) {
        memberService.delete(id);
    }
}
