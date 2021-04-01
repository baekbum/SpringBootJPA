package bb.toy.api.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthProcessService {

    public void authCheck(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            String userId = authentication.getName();

            if (userId.equals("anonymousUser")) {
                throw new IllegalStateException("접근 권한이 없습니다.");
            }
        }
    }
}
