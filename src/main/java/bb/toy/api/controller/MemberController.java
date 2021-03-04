package bb.toy.api.controller;


import bb.toy.api.domain.Address;
import bb.toy.api.domain.Grade;
import bb.toy.api.domain.Member;
import bb.toy.api.domain.dto.RequestMemberDto;
import bb.toy.api.domain.dto.ResponseMemberDto;
import bb.toy.api.domain.dto.ResultMemberDto;
import bb.toy.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 등록
    @PostMapping("/api/member")
    public String addMember(@RequestBody @Valid RequestMemberDto requestMemberDto) {
        Member member = mappingMember(requestMemberDto, "C");

        String id = memberService.save(member);

        return id;
    }

    // 1건 조회
    @GetMapping("/api/member/{id}")
    public ResponseMemberDto findMember(@PathVariable("id") String id) {
        Member member = memberService.findById(id);

        ResponseMemberDto memberDto = new ResponseMemberDto(member.getId(), member.getName(), member.getTel(), member.getGrade().getId());

        return memberDto;
    }

    // 전체 조회
    @GetMapping("/api/member/all")
    public ResultMemberDto findMembers() {
        List<Member> members = memberService.findAll();
        List<ResponseMemberDto> memberDtos = members.stream()
                                                    .map(o -> new ResponseMemberDto(o.getId(), o.getName(), o.getTel(), o.getGrade().getId()))
                                                    .collect(Collectors.toList());

        return new ResultMemberDto(memberDtos.size(), memberDtos);
    }

    // 수정
    @PutMapping("/api/member")
    public void updateMember(@RequestBody @Valid RequestMemberDto requestMemberDto) {
        Member member = mappingMember(requestMemberDto, "U");
        memberService.update(member);
    }

    // 삭제
    @DeleteMapping("/api/member/{id}")
    public void deleteMember(@PathVariable("id") String id) {
        memberService.delete(id);
    }

    private Member mappingMember(RequestMemberDto requestMemberDto, String status) {
        Member member = new Member();

        if (status.equals("C")) {
            member.setEnable(0);
            member.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        member.setId(requestMemberDto.getId());
        member.setPassword(requestMemberDto.getPassword());
        member.setName(requestMemberDto.getName());
        member.setTel(requestMemberDto.getTel());
        member.setGrade(new Grade(requestMemberDto.getGrade()));
        member.setAddress(new Address(requestMemberDto.getCity(), requestMemberDto.getStreet(), requestMemberDto.getZipcode()));
        member.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return member;
    }
}
