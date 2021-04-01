package bb.toy.api.error;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
                .body(new ApiExceptionEntity(ExceptionEnum.RUNTIME_EXCEPTION.getCode(), e.getMessage()));
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final IllegalStateException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ILLEGAL_STATE_EXCEPTION.getStatus())
                .body(new ApiExceptionEntity(ExceptionEnum.ILLEGAL_STATE_EXCEPTION.getCode(), e.getMessage()));
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
                .body(new ApiExceptionEntity(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode(), ExceptionEnum.ACCESS_DENIED_EXCEPTION.getMessage()));
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final NoSuchElementException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.NO_SUCH_ELEMENT_EXCEPTION.getStatus())
                .body(new ApiExceptionEntity(ExceptionEnum.NO_SUCH_ELEMENT_EXCEPTION.getCode(), ExceptionEnum.NO_SUCH_ELEMENT_EXCEPTION.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(new ApiExceptionEntity(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage()));
    }
}