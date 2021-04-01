package bb.toy.api.dto.member;

import bb.toy.api.domain.Member;
import lombok.Data;

@Data
public class ResponseMemberDto {
    private Long id;
    private String name;
    private String tel;
    private String address;
    private String rankId;
    private String rankName;
    private String positionId;
    private String positionName;
    private String teamId;
    private String teamName;
    private String createDate;
    private String updateDate;
    private String isRetire;

    public ResponseMemberDto (Member member) {
        setId(member.getId());
        setName(member.getName());
        setTel(member.getTel());
        setAddress(member.getAddress());
        setRankId(member.getRank().getId());
        setRankName(member.getRank().getName());
        setPositionId(member.getPosition().getId());
        setPositionName(member.getPosition().getName());
        setTeamId(member.getTeam().getId());
        setTeamName(member.getTeam().getName());
        setCreateDate(member.getCreateDate());
        setUpdateDate(member.getUpdateDate());
        setIsRetire(member.getIsRetire());
    }
}
