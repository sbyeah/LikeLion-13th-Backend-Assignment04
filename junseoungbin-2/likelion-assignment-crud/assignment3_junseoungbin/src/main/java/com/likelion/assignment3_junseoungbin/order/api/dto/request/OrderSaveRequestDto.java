package com.likelion.assignment3_junseoungbin.order.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderSaveRequestDto(

        @NotNull(message = "사용자명은 필수로 입력해야 합니다.")
        String customerId,

        @NotBlank(message = "내용을 필수로 입력해야 합니다.")
        String orderId,

        @NotBlank(message = "제품은 필수로 입력해야 합니다.")
        Long productId,

        @NotNull(message = "수량은 필수로 입력해야 합니다.")
        int quantity
) {
}