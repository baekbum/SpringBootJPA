package bb.toy.api.domain;

import bb.toy.api.dto.member.RequestMemberDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    @Column(name = "member_name")
    private String name;

    @JsonIgnore
    @NotEmpty
    private String password;

    private String tel;
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String createDate;
    private String updateDate;

    private String isRetire;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public static Member addMemberInit(String name, String password , String tel, String address, Rank rank, Position position, Team team, String createDate, String updateDate, String isRetire, List<String> roles) {
        Member member = new Member();

        member.setName(name);
        member.setPassword(password);
        member.setTel(tel);
        member.setAddress(address);
        member.setRank(rank);
        member.setPosition(position);
        member.setTeam(team);
        member.setCreateDate(createDate);
        member.setUpdateDate(updateDate);
        member.setIsRetire(isRetire);
        member.setRoles(roles);

        return member;
    }

    public static Member addMember(RequestMemberDto dto, Rank rank, Position position, Team team) {
        Member member = new Member();
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        member.setTel(dto.getTel());
        member.setAddress(dto.getAddress());
        member.setRank(rank);
        member.setPosition(position);
        member.setTeam(team);
        member.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        member.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        member.setIsRetire("N");
        member.setRoles(Collections.singletonList("ROLE_USER"));

        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
