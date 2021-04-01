package bb.toy.api.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Rank {
    @Id
    @NotEmpty
    @Column(name = "rank_id")
    private String id;

    @NotEmpty
    @Column(name = "rank_name")
    private String name;

    public static Rank addRank (String id, String name) {
        Rank rank = new Rank();
        rank.setId(id);
        rank.setName(name);

        return rank;
    }
}
