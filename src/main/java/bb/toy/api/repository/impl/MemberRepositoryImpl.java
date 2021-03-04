package bb.toy.api.repository.impl;

import bb.toy.api.domain.Member;
import bb.toy.api.repository.iface.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    @Override
    public void saveMember(Member member) {
        em.persist(member);
    }

    @Override
    public Member findMember(String id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findMembers() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public void deleteMember(String id) {
        Member member = findMember(id);
        em.remove(member);
    }
}
