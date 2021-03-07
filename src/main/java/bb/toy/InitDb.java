package bb.toy;

import bb.toy.api.domain.Address;
import bb.toy.api.domain.Grade;
import bb.toy.api.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            Grade gradeB = addGrade("B");
            Grade gradeS = addGrade("S");
            Grade gradeG = addGrade("G");
            Grade gradeA = addGrade("A");

            em.persist(gradeB);
            em.persist(gradeS);
            em.persist(gradeG);
            em.persist(gradeA);
        }

        public void Member() {
            Member member1 = addMember("admin", "1234", "관리자", "010-1111-1111", "A", "서울", "관악", "01234");
            Member member2 = addMember("user1", "1234", "유저1", "010-1111-1111", "G", "서울", "관악", "01234");

            em.persist(member1);
            em.persist(member2);
        }

        public Member addMember(String id, String pw, String name, String tel, String grade, String city, String street, String zipcode) {
            Member member = new Member();
            member.setId(id);
            member.setPassword(pw);
            member.setName(name);
            member.setTel(tel);
            member.setGrade(new Grade(grade));
            member.setAddress(new Address(city, street, zipcode));
            member.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            member.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            return member;
        }

        public Grade addGrade(String Id) {
            Grade grade = new Grade(Id);

            return grade;
        }
    }
}
