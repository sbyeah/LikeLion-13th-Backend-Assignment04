package com.likelion.assignment3_junseoungbin.product.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProductUpdateRequestDto(
        @NotBlank(message = "name은 필수입니다.")
        String name,

        int price
) {}
