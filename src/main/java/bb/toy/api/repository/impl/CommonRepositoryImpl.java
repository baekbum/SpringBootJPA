package bb.toy.api.repository.impl;

import bb.toy.api.domain.Position;
import bb.toy.api.domain.Rank;
import bb.toy.api.domain.Team;
import bb.toy.api.repository.iface.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommonRepositoryImpl implements CommonRepository {

    private final EntityManager em;

    @Override
    public List<Rank> getRanks() {
        return em.createQuery("select r from Rank r", Rank.class)
                .getResultList();
    }

    @Override
    public List<Position> getPositions() {
        return em.createQuery("select p from Position p", Position.class)
                .getResultList();
    }

    @Override
    public List<Team> getTeams() {
        return em.createQuery("select t from Team t", Team.class)
                .getResultList();
    }

    @Override
    public Rank findRank(String id) {
        return em.find(Rank.class, id);
    }

    @Override
    public Position findPosition(String id) {
        return em.find(Position.class, id);
    }

    @Override
    public Team findTeam(String id) {
        return em.find(Team.class, id);
    }
}
