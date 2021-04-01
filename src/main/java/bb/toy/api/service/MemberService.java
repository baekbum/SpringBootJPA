package bb.toy.api.service;

import bb.toy.api.domain.Member;
import bb.toy.api.domain.Position;
import bb.toy.api.domain.Rank;
import bb.toy.api.domain.Team;
import bb.toy.api.dto.member.RequestMemberDto;
import bb.toy.api.dto.member.SearchCondMember;
import bb.toy.api.repository.iface.CommonRepository;
import bb.toy.api.repository.iface.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final CommonRepository commonRepository;
    private final PasswordEncoder passwordEncoder;

    // C
    @Transactional(readOnly = false)
    public Long save(RequestMemberDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Rank rank = commonRepository.findRank(dto.getRankId());
        Position position = commonRepository.findPosition(dto.getPositionId());
        Team team = commonRepository.findTeam(dto.getTeamId());

        Member member = Member.addMember(dto, rank, position, team);

        memberRepository.saveMember(member);
        return member.getId();
    }

    // R
    public Member findById(Long id) {
        Member findMember = memberRepository.findById(id)
                                            .orElseThrow(() -> new IllegalStateException("사용자를 찾을 수 없습니다."));
        return findMember;
    }

    public Long findMembersCount(SearchCondMember searchCondMember) {
        Long count = memberRepository.findMembersCount(searchCondMember);
        return count;
    }

    public List<Member> findMembers(SearchCondMember searchCondMember) {
        List<Member> members = memberRepository.findMembers(searchCondMember);
        return members;
    }

    // U
    @Transactional(readOnly = false)
    public void update(RequestMemberDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Rank rank = commonRepository.findRank(dto.getRankId());
        Position position = commonRepository.findPosition(dto.getPositionId());
        Team team = commonRepository.findTeam(dto.getTeamId());

        Member findMember = memberRepository.findById(dto.getId())
                                            .orElseThrow(() -> new IllegalStateException("사용자를 찾을 수 없습니다."));
        findMember.setName(dto.getName());
        findMember.setPassword(dto.getPassword());
        findMember.setTel(dto.getTel());
        findMember.setRank(rank);
        findMember.setPosition(position);
        findMember.setTeam(team);
        findMember.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        findMember.setIsRetire(dto.getIsRetire());
    }

    // D
    @Transactional(readOnly = false)
    public void delete(Long id) {
        memberRepository.deleteMember(id);
    }

    /*private void validateDuplicateMember(Member member) {

        Optional<Member> findMember = memberRepository.findMember(member.getId());

        if (findMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }*/
}
