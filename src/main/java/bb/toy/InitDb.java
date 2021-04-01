package bb.toy;

import bb.toy.api.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    protected void Init() {
        //initService.Team();
        //initService.Rank();
        //initService.Position();
        //initService.Member();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final EntityManager em;
        private final PasswordEncoder passwordEncoder;

        public void Team() {
            Team team1 = Team.addTeam("100", "본사", "H");
            Team team2 = Team.addTeam("110", "인사 그룹", "G");
            Team team3 = Team.addTeam("120", "영업 그룹", "G");
            Team team4 = Team.addTeam("130", "컨설팅 그룹", "G");
            Team team5 = Team.addTeam("140", "개발 그룹", "G");
            Team team6 = Team.addTeam("141", "개발 1팀", "T");

            em.persist(team1);
            em.persist(team2);
            em.persist(team3);
            em.persist(team4);
            em.persist(team5);
            em.persist(team6);
        }

        public void Rank() {
            Rank rank1 = Rank.addRank("0", "사장");
            Rank rank2 = Rank.addRank("1", "이사");
            Rank rank3 = Rank.addRank("2", "부장");
            Rank rank4 = Rank.addRank("3", "차장");
            Rank rank5 = Rank.addRank("4", "과장");
            Rank rank6 = Rank.addRank("5", "대리");
            Rank rank7 = Rank.addRank("6", "사원");
            Rank rank8 = Rank.addRank("9", "관리자");

            em.persist(rank1);
            em.persist(rank2);
            em.persist(rank3);
            em.persist(rank4);
            em.persist(rank5);
            em.persist(rank6);
            em.persist(rank7);
            em.persist(rank8);
        }

        public void Position() {
            Position position1 = Position.addPosition("0", "사장");
            Position position2 = Position.addPosition("1", "그룹장");
            Position position3 = Position.addPosition("2", "팀장");
            Position position4 = Position.addPosition("3", "사원");
            Position position5 = Position.addPosition("4", "관리자");

            em.persist(position1);
            em.persist(position2);
            em.persist(position3);
            em.persist(position4);
            em.persist(position5);
        }

        public void Member() {
            String password = passwordEncoder.encode("1234");
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Member member1 = Member.addMemberInit("관리자", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("9", "관리자"), Position.addPosition("4", "관리자"), Team.addTeam("100", "본사", "H"), date, date, "N", Collections.singletonList("ROLE_ADMIN"));
            Member member2 = Member.addMemberInit("사장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("0", "사장"), Position.addPosition("0", "사장"), Team.addTeam("100", "본사", "H"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member3 = Member.addMemberInit("인사 그룹장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("1", "이사"), Position.addPosition("1", "그룹장"), Team.addTeam("110", "인사 그룹", "G"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member4 = Member.addMemberInit("영업 그룹장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("2", "부장"), Position.addPosition("1", "그룹장"), Team.addTeam("120", "영업 그룹", "G"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member5 = Member.addMemberInit("컨설팅 그룹장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("3", "차장"), Position.addPosition("1", "그룹장"), Team.addTeam("130", "영업 그룹", "G"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member6 = Member.addMemberInit("개발 그룹장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("3", "차장"), Position.addPosition("1", "그룹장"), Team.addTeam("140", "개발 그룹", "G"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member7 = Member.addMemberInit("개발 1팀 팀장", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("4", "과장"), Position.addPosition("2", "팀장"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member8 = Member.addMemberInit("개발 1팀 대리", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("5", "대리"), Position.addPosition("3", "사원"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member9 = Member.addMemberInit("개발 1팀 사원1", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("6", "사원"), Position.addPosition("3", "사원"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member10 = Member.addMemberInit("개발 1팀 사원2", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("6", "사원"), Position.addPosition("3", "사원"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member11 = Member.addMemberInit("개발 1팀 사원3", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("6", "사원"), Position.addPosition("3", "사원"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));
            Member member12 = Member.addMemberInit("개발 1팀 사원4", password, "010-1111-1111", "서울시 관악구 관악로", Rank.addRank("6", "사원"), Position.addPosition("3", "사원"), Team.addTeam("141", "개발 1팀", "T"), date, date, "N", Collections.singletonList("ROLE_USER"));

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
            em.persist(member6);
            em.persist(member7);
            em.persist(member8);
            em.persist(member9);
            em.persist(member10);
            em.persist(member11);
            em.persist(member12);
        }
    }
}
