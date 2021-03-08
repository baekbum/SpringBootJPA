package bb.toy.api.domain;

import bb.toy.api.dto.member.RequestMemberDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

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

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public static Member addMember(RequestMemberDto dto, String status) {
        Member member = new Member();

        member.setId(dto.getId());
        member.setPassword(dto.getPassword());
        member.setName(dto.getName());
        member.setTel(dto.getTel());
        member.setGrade(Grade.addGrade(dto.getGradeId()));
        member.setAddress(new Address(dto.getCity(), dto.getStreet(), dto.getZipcode()));
        member.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        if (status.equals("C")) {
            member.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            member.setEnable(0);
        }

        return member;
    }
}
