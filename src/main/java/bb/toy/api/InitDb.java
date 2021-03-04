package bb.toy.api;

import bb.toy.api.domain.Grade;
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
        initService.addGrade();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final EntityManager em;

        public void addGrade() {
            Grade gradeB = new Grade("B");
            Grade gradeS = new Grade("S");
            Grade gradeG = new Grade("G");

            em.persist(gradeB);
            em.persist(gradeS);
            em.persist(gradeG);
        }
    }
}
