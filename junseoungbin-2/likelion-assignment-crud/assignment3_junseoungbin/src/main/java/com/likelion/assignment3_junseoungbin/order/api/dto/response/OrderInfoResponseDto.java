package com.likelion.assignment3_junseoungbin.order.api.dto.response;

import com.likelion.assignment3_junseoungbin.order.domain.Order;

public record OrderInfoResponseDto(
        String product,
        String customerId,
        int quantity
) {
    public static OrderInfoResponseDto from(Order order) {
        return new OrderInfoResponseDto(
                order.getProduct().getName(),
                order.getCustomerId(),
                order.getQuantity()
        );
    }
}
