package bb.toy.api.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiExceptionEntity {
    private String errorCode;
    private String errorMessage;
}
