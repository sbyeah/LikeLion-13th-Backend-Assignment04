package com.likelion.assignment3_junseoungbin.product.api.dto.response;

import com.likelion.assignment3_junseoungbin.product.domain.Product;
import lombok.Builder;

@Builder
public record ProductInfoResponseDto(
        Long id,
        String name,
        int price,
        String category
) {
    public static ProductInfoResponseDto from(Product product) {
        return ProductInfoResponseDto.builder()
                .id(product.getProductId())  // Long 타입과 맞음
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory().name())
                .build();
    }
}
