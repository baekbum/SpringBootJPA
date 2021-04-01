package bb.toy.api.repository.iface;

import bb.toy.api.domain.Position;
import bb.toy.api.domain.Rank;
import bb.toy.api.domain.Team;

import java.util.List;

public interface CommonRepository {
    Rank findRank(String id);

    Position findPosition(String id);

    Team findTeam(String id);

    List<Rank> getRanks();

    List<Position> getPositions();

    List<Team> getTeams();
}
