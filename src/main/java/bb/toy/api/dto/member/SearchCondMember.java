package bb.toy.api.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SearchCondMember {
    private String searchCond;
    private String searchString;
    private int offset;
    private int limit;
}
