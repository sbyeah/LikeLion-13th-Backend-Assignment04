package com.likelion.assignment3_junseoungbin.order.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderListResponseDto(
        List<OrderInfoResponseDto> orderList
) {
    public static OrderListResponseDto from(List<OrderInfoResponseDto> orderList) {
        return OrderListResponseDto.builder()
                .orderList(orderList)
                .build();
    }
}
