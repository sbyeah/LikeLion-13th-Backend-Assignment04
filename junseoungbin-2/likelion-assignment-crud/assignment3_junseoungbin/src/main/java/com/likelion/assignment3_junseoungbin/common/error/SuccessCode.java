package com.likelion.assignment3_junseoungbin.common.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    // 200 ok
    GET_SUCCESS(HttpStatus.OK, "성공적으로 조회했습니다."),
    PRODUCT_UPDATE_SUCCESS(HttpStatus.OK, "제품이 성공적으로 수정되었습니다."),
    ORDER_UPDATE_SUCCESS(HttpStatus.OK, "메뉴가 성공적으로 수정되었습니다."),
    PRODUCT_DELETE_SUCCESS(HttpStatus.OK, "제품이 성공적으로 삭제되었습니다."),
    ORDER_DELETE_SUCCESS(HttpStatus.OK, "메뉴가 성공적으로 삭제되었습니다."),


    // 201 create
    PRODUCT_SAVE_SUCCESS(HttpStatus.CREATED, "제품이 성공적으로 생성되었습니다."),
    ORDER_SAVE_SUCCESS(HttpStatus.CREATED, "메뉴가 성공적으로 생성되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
