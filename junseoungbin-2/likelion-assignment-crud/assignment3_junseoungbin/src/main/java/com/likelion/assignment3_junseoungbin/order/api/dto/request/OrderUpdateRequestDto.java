package com.likelion.assignment3_junseoungbin.order.api.dto.request;

public record OrderUpdateRequestDto (
    String productId,
    int quantity,
    String orderDate,
    String orderId
) {
}
