package com.likelion.assignment3_junseoungbin.order.application;

import com.likelion.assignment3_junseoungbin.product.domain.Product;
import com.likelion.assignment3_junseoungbin.product.domain.repository.ProductRepository;
import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderSaveRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderUpdateRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderInfoResponseDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderListResponseDto;
import com.likelion.assignment3_junseoungbin.order.domain.Order;
import com.likelion.assignment3_junseoungbin.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void orderSave(OrderSaveRequestDto dto) {
        Product product = findProductById(dto.productId());

        Order order = Order.builder()
                .customerId(dto.customerId())
                .quantity(dto.quantity())
                .product(product)
                .build();

        orderRepository.save(order);
    }

    public OrderListResponseDto orderFindProduct(Long productId) {
        Product product = findProductById(productId);

        List<Order> orderList = orderRepository.findByProduct(product);
        List<OrderInfoResponseDto> orderInfoResponseDtos = orderList.stream()
                .map(OrderInfoResponseDto::from)
                .toList();

        return OrderListResponseDto.from(orderInfoResponseDtos);
    }

    @Transactional
    public void orderUpdate(Long orderId, OrderUpdateRequestDto dto) {
        Order order = findOrderById(orderId);
        order.update(dto);
    }

    @Transactional
    public void orderDelete(Long orderId) {
        Order order = findOrderById(orderId);
        orderRepository.delete(order);
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
    }

    private Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 없습니다."));
    }
}
