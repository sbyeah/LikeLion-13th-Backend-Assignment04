package com.likelion.assignment3_junseoungbin.order.api;

import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderSaveRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.request.OrderUpdateRequestDto;
import com.likelion.assignment3_junseoungbin.order.api.dto.response.OrderListResponseDto;
import com.likelion.assignment3_junseoungbin.order.application.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Controller
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<String> orderSave(@RequestBody @Valid OrderSaveRequestDto orderSaveRequestDto) {
        orderService.orderSave(orderSaveRequestDto);
        return new ResponseEntity<>("게시물 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<OrderListResponseDto> myOrderFindAll(@PathVariable("productId") Long productId) {
        OrderListResponseDto orderListResponseDto = orderService.orderFindProduct(productId);
        return new ResponseEntity<>(orderListResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<String> orderUpdate(
            @PathVariable("orderId") Long orderId,
            @RequestBody @Valid OrderUpdateRequestDto orderUpdateRequestDto) {
        orderService.orderUpdate(orderId, orderUpdateRequestDto);
        return new ResponseEntity<>("게시물 수정", HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> orderDelete(@PathVariable("orderId") Long orderId) {
        orderService.orderDelete(orderId);
        return new ResponseEntity<>("게시물 삭제", HttpStatus.OK);
    }
}
