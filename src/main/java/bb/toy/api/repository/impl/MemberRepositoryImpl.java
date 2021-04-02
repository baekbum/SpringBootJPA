package bb.toy.api.repository.impl;

import bb.toy.api.domain.*;
import bb.toy.api.dto.member.SearchCondMember;
import bb.toy.api.repository.iface.MemberRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    @Override
    public void saveMember(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public Long findMembersCount(SearchCondMember searchCondMember) {
        QMember member = QMember.member;

        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
                .select(member)
                .from(member)
                .where(statusEq(searchCondMember))
                .fetchCount();
    }

    @Override
    public List<Member> findMembers(SearchCondMember searchCondMember) {
        QMember member = QMember.member;

        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
                .select(member)
                .from(member)
                .where(statusEq(searchCondMember))
                .orderBy(member.id.asc())
                .offset(searchCondMember.getOffset())
                .limit(searchCondMember.getLimit())
                .fetch();
    }

    @Override
    public void deleteMember(Long id) {
        Optional<Member> member = findById(id);
        if (member.isPresent()) {
            em.remove(member.get());
        }
    }

    private BooleanExpression statusEq(SearchCondMember searchCondMember) {

        if (searchCondMember.getSearchCond().equals("ID")) {
            return QMember.member.id.eq(Long.parseLong(searchCondMember.getSearchString()));
        } else if (searchCondMember.getSearchCond().equals("NAME")) {
            return QMember.member.name.contains(searchCondMember.getSearchString());
        } else if (searchCondMember.getSearchCond().equals("RANK")) {
            return QMember.member.rank.id.contains(searchCondMember.getSearchString());
        } else if (searchCondMember.getSearchCond().equals("POSITION")) {
            return QMember.member.position.id.contains(searchCondMember.getSearchString());
        } else if (searchCondMember.getSearchCond().equals("TEAM")) {
            return QMember.member.team.id.contains(searchCondMember.getSearchString());
        } else if (searchCondMember.getSearchCond().equals("RETIRE")) {
            return QMember.member.isRetire.eq(searchCondMember.getSearchString());
        } else {
            return null;
        }
    }
}
