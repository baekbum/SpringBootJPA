package bb.toy.api.service;

import bb.toy.api.domain.Position;
import bb.toy.api.domain.Rank;
import bb.toy.api.domain.Team;
import bb.toy.api.repository.iface.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final CommonRepository commonRepository;

    public List<Rank> getRanks() {
        return commonRepository.getRanks();
    }

    public List<Position> getPositions() {
        return commonRepository.getPositions();
    }

    public List<Team> getTeams() {
        return commonRepository.getTeams();
    }

    public Rank findRank(String id) {
        return commonRepository.findRank(id);
    }

    public Position findPosition(String id) {
        return commonRepository.findPosition(id);
    }

    public Team findTeam(String id) {
        return commonRepository.findTeam(id);
    }
}
