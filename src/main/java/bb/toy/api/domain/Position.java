package bb.toy.api.domain;

import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Position {
    @Id
    @NotEmpty
    @Column(name = "position_id")
    private String id;

    @NotEmpty
    @Column(name = "position_name")
    private String name;

    public static Position addPosition (String id, String name) {
        Position position = new Position();
        position.setId(id);
        position.setName(name);

        return position;
    }
}
