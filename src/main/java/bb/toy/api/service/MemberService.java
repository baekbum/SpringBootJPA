package bb.toy.api.service;

import bb.toy.api.domain.Member;
import bb.toy.api.repository.iface.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public String save(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.saveMember(member);
        return member.getId();
    }

    public Member findById(String id) {
        Member findMember = memberRepository.findMember(id);
        return findMember;
    }

    public List<Member> findAll() {
        List<Member> members = memberRepository.findMembers();
        return members;
    }

    @Transactional(readOnly = false)
    public void update(Member member) {
        Member findMember = memberRepository.findMember(member.getId());
        findMember.setPassword(member.getPassword());
        findMember.setName(member.getName());
        findMember.setTel(member.getTel());
        findMember.setGrade(member.getGrade());
        findMember.setAddress(member.getAddress());
        findMember.setUpdateDate(member.getUpdateDate());
    }

    @Transactional(readOnly = false)
    public void delete(String id) {
        memberRepository.deleteMember(id);
    }

    private void validateDuplicateMember(Member member) {

        Member findMember = memberRepository.findMember(member.getId());

        if(!(findMember == null)) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
