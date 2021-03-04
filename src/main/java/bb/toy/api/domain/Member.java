package bb.toy.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member {

    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    //private Long idx;

    @Id
    @Column(name = "member_id")
    private String id;

    @NotEmpty
    private String password;

    @NotEmpty
    @Column(name = "member_name")
    private String name;

    @NotEmpty
    private String tel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Embedded
    private Address address;

    private String createDate;
    private String updateDate;

    private int enable;

    //@OneToMany(mappedBy = "member")
    //private List<Order> orders = new ArrayList<>();
}
