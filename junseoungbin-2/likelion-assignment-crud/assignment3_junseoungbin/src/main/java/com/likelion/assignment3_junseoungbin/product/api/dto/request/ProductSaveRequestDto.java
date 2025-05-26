package com.likelion.assignment3_junseoungbin.product.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProductSaveRequestDto(
        @NotBlank(message = "name은 필수입니다.")
        String name,

        @NotBlank(message = "category는 필수입니다.")
        String category,

        int price,

        @NotBlank(message = "productId는 필수입니다.")
        String productId
) {}
