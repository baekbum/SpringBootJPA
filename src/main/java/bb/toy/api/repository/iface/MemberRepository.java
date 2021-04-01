package bb.toy.api.repository.iface;

import bb.toy.api.domain.Member;
import bb.toy.api.domain.Position;
import bb.toy.api.domain.Rank;
import bb.toy.api.domain.Team;
import bb.toy.api.dto.member.SearchCondMember;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void saveMember(Member member);

    Optional<Member> findById(Long id);

    Long findMembersCount(SearchCondMember searchCondMember);

    List<Member> findMembers(SearchCondMember searchCondMember);

    void deleteMember(Long id);
}
