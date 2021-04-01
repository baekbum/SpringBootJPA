package bb.toy.api.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Team {

    @Id
    @NotEmpty
    @Column(name = "team_id")
    private String id;

    @NotEmpty
    @Column(name = "team_name")
    private String name;

    @NotEmpty
    @Column(name = "team_division")
    private String division;

    public static Team addTeam (String id, String name, String division) {
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        team.setDivision(division);

        return team;
    }
}
