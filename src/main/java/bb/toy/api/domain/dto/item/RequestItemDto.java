package bb.toy.api.domain.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class RequestItemDto {

    private Long id;

    @NotEmpty
    private String name;
    private int price;
    private int stockQuantity;

}
