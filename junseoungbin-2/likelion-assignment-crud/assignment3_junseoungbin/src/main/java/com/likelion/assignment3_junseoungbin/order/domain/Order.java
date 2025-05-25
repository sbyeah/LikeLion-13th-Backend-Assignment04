package com.likelion.assignment3_junseoungbin.order.domain;

import com.likelion.assignment3_junseoungbin.product.domain.Product;
import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;  // PK Long 타입

    private String customerId;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Order(String customerId, int quantity, Product product) {
        this.customerId = customerId;
        this.quantity = quantity;
        this.product = product;
    }

    public void update(OrderUpdateRequestDto dto) {
        this.quantity = dto.quantity();
        // product 변경 로직 필요시 추가
    }
}
