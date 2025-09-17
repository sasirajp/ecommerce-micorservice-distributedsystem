package com.example.order_service.rest;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("get_order")
    public Order getOrder() {
        return new Order("Monica", 100, "upi", "razaorPay", List.of("a", "b"));
    }

    @GetMapping("get_order/user")
    public Order getOrderUser(@RequestParam(value = "userName") String userName) {
        return orderService.getOrderByUser(userName);
    }


}
