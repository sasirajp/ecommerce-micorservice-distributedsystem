package com.example.order_service.service;

import com.example.order_service.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    public Order getOrderByUser(String userName) {
        return Order.getOrders().stream().filter(o->o.getUser().equals(userName)).findFirst().orElse(null);
    }

}
