package com.likelion.assignment3_junseoungbin.product.application;

import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.request.ProductUpdateRequestDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.assignment3_junseoungbin.product.api.dto.response.ProductListResponseDto;
import com.likelion.assignment3_junseoungbin.product.domain.Category;
import com.likelion.assignment3_junseoungbin.product.domain.Product;
import com.likelion.assignment3_junseoungbin.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void productSave(ProductSaveRequestDto dto) {
        Product product = Product.builder()
                .name(dto.name())
                .price(dto.price())
                .category(Category.valueOf(dto.category()))
                .build();
        productRepository.save(product);
    }

    public ProductInfoResponseDto productFind(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
        return ProductInfoResponseDto.from(product);
    }

    public ProductListResponseDto productFindAll() {
        List<Product> products = productRepository.findAll();
        List<ProductInfoResponseDto> productDtos = products.stream()
                .map(ProductInfoResponseDto::from)
                .toList();
        return ProductListResponseDto.from(productDtos);
    }

    @Transactional
    public void productUpdate(Long id, ProductUpdateRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
        product.update(dto);
    }

    @Transactional
    public void productDelete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
        productRepository.delete(product);
    }
}
