package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class Order {
    String user;
    Integer amount;
    String paymentType;
    String paymentProvider;
    List<String> products;

    public static List<Order> getOrders() {
        return List.of(new Order("sasi", 100, "upi", "razaorPay", List.of("a", "b")),
                new Order("Monica", 50, "Credit Card", "jusPay", List.of("a", "b")),
                new Order("Aryabhatta", 100, "Debit Card", "Paypal", List.of("a", "b"))
                );
    }
}
