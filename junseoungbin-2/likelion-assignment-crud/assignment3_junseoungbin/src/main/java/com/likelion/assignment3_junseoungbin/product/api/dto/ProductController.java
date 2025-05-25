package com.likelion.assignment3_junseoungbin.product.api.dto;

import com.likelion.assignment3_junseoungbin.common.template.ApiResTemplate;
import com.likelion.assignment3_junseoungbin.common.error.SuccessCode;
import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductUpdateRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductListResponseDto;
import com.likelion.assignment3_junseoungbin.product.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Void> productSave(@Validated @RequestBody ProductSaveRequestDto dto) {
        productService.productSave(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResTemplate<ProductInfoResponseDto>> productFind(@PathVariable Long id) {
        ProductInfoResponseDto dto = productService.productFind(id);
        return ResponseEntity.ok(ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, dto));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResTemplate<ProductListResponseDto>> productFindAll() {
        ProductListResponseDto dto = productService.productFindAll();
        return ResponseEntity.ok(ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> productUpdate(@PathVariable Long id, @Validated @RequestBody ProductUpdateRequestDto dto) {
        productService.productUpdate(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> productDelete(@PathVariable Long id) {
        productService.productDelete(id);
        return ResponseEntity.ok().build();
    }
}
