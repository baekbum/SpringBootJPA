package bb.toy.api.controller;

import bb.toy.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문
    @PostMapping("/api/order")
    public Long addOrder() {
        return 0L;
    }
}
