package bb.toy.api.controller;

import bb.toy.api.domain.Order;
import bb.toy.api.dto.order.RequestOrderDto;
import bb.toy.api.dto.order.ResponseOrderDto;
import bb.toy.api.dto.order.ResultOrderDto;
import bb.toy.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문 등록
    @PostMapping("/api/order")
    public void addOrder(@RequestBody @Valid RequestOrderDto requestOrderDto) {
        orderService.addOrder(requestOrderDto);
    }

    // 주문 조회 (주문 id, 한 건)
    @GetMapping("/api/order/{id}")
    public ResponseOrderDto findOrder(@PathVariable("id") Long id) {
        Order order = orderService.findOrder(id);
        ResponseOrderDto dto = new ResponseOrderDto(order);
        return dto;
    }

    // 주문 조회 (사용자 id, N 건)
    @GetMapping("/api/orders/{id}")
    public ResultOrderDto findOrderByMember(@PathVariable("id") String id) {
        List<Order> orders = orderService.findOrderByName(id);
        List<ResponseOrderDto> dtos = orders.stream()
                                           .map(o -> new ResponseOrderDto(o))
                                           .collect(Collectors.toList());

        return new ResultOrderDto(dtos.size(), dtos);
    }

    // 주문 취소
    @DeleteMapping("/api/order/{id}")
    public void cancelOrder(@PathVariable("id") Long id) {
        orderService.cancelOrder(id);
    }


}