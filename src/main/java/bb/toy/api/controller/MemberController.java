package bb.toy.api.controller;


import bb.toy.api.domain.Member;
import bb.toy.api.dto.member.RequestMemberDto;
import bb.toy.api.dto.member.ResponseMemberDto;
import bb.toy.api.dto.member.ResultMemberDto;
import bb.toy.api.dto.member.SearchCondMember;
import bb.toy.api.service.MemberService;
import bb.toy.api.service.AuthProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class MemberController {

    private final MemberService memberService;
    private final AuthProcessService authProcessService;

    // 등록
    @PostMapping("/api/member")
    public Long saveMember(@RequestBody @Valid RequestMemberDto requestMemberDto) {
        authProcessService.authCheck(SecurityContextHolder.getContext().getAuthentication());

        Long id = memberService.save(requestMemberDto);

        return id;
    }

    // 1건 조회
    @GetMapping("/api/member/{id}")
    public ResponseMemberDto findMember(@PathVariable("id") Long id) {
        Member member = memberService.findById(id);

        ResponseMemberDto memberDto = new ResponseMemberDto(member);

        return memberDto;
    }

    // 전체 조회
    @GetMapping("/api/member/all")
    public ResultMemberDto findMembers(@ModelAttribute SearchCondMember searchCondMember) {
        Long totalCount = memberService.findMembersCount(searchCondMember);
        List<Member> members = memberService.findMembers(searchCondMember);

        List<ResponseMemberDto> dtos = members.stream()
                .map(o -> new ResponseMemberDto(o))
                .collect(Collectors.toList());

        return new ResultMemberDto(totalCount, dtos);
    }

    // 수정
    @PutMapping("/api/member/{id}")
    public Long updateMember(@PathVariable("id") Long id, @RequestBody @Valid RequestMemberDto requestMemberDto) {
        authProcessService.authCheck(SecurityContextHolder.getContext().getAuthentication());

        memberService.update(id, requestMemberDto);

        return id;
    }

    // 삭제
    @DeleteMapping("/api/member/{id}")
    public Long deleteMember(@PathVariable("id") Long id) {
        authProcessService.authCheck(SecurityContextHolder.getContext().getAuthentication());

        memberService.delete(id);

        return id;
    }
}
