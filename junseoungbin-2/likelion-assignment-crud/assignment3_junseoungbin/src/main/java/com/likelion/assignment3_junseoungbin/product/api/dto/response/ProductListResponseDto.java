package com.likelion.assignment3_junseoungbin.product.api.dto.response;

import lombok.Builder;
import java.util.List;

@Builder
public record ProductListResponseDto(
        List<ProductInfoResponseDto> productList
) {
    public static ProductListResponseDto from(List<ProductInfoResponseDto> productList) {
        return ProductListResponseDto.builder()
                .productList(productList)
                .build();
    }
}
