package bb.toy;

import bb.toy.api.domain.Grade;
import bb.toy.api.domain.Member;
import bb.toy.api.dto.member.RequestMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void Init() {
        initService.Grade();
        initService.Member();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final EntityManager em;

        public void Grade() {
            Grade gradeB = Grade.addGrade("B");
            Grade gradeS = Grade.addGrade("S");
            Grade gradeG = Grade.addGrade("G");
            Grade gradeA = Grade.addGrade("A");

            em.persist(gradeB);
            em.persist(gradeS);
            em.persist(gradeG);
            em.persist(gradeA);
        }

        public void Member() {
            Member member1 = Member.addMember(new RequestMemberDto("admin", "1234", "관리자", "010-1111-1111", "A", "서울", "관악", "01234", 0), "C");
            Member member2 = Member.addMember(new RequestMemberDto("user", "1234", "유저", "010-1111-1111", "G", "서울", "관악", "01234", 0), "C");

            em.persist(member1);
            em.persist(member2);
        }
    }
}
