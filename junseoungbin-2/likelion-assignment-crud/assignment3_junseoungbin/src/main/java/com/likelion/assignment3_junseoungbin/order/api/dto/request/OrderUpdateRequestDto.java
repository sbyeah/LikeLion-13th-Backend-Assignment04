package com.likelion.assignment3_junseoungbin.order.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record OrderUpdateRequestDto(
        @NotBlank(message = "productId는 필수입니다.")
        String productId,

        int quantity,

        @NotBlank(message = "orderDate는 필수입니다.")
        String orderDate,

        @NotBlank(message = "orderId는 필수입니다.")
        String orderId
) {
}