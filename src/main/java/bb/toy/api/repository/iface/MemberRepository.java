package bb.toy.api.repository.iface;

import bb.toy.api.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface MemberRepository {

    public void saveMember(Member member);

    public Member findMember(String id);

    public List<Member> findMembers();

    public void deleteMember(String id);
}
