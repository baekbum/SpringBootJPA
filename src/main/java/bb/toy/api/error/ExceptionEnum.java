package bb.toy.api.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {
    ILLEGAL_STATE_EXCEPTION(HttpStatus.BAD_REQUEST, "E0000"),
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002", "권한이 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
    NO_SUCH_ELEMENT_EXCEPTION(HttpStatus.BAD_REQUEST, "E0004", "데이터가 존재하지 않습니다."),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(HttpStatus.BAD_REQUEST, "E0005", "빈 값이 존재합니다."),
    SECURITY(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
