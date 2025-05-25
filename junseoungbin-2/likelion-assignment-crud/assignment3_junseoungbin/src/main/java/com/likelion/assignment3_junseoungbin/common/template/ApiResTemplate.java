package com.likelion.assignment3_junseoungbin.common.template;

import com.likelion.assignment3_junseoungbin.common.error.ErrorCode;
import com.likelion.assignment3_junseoungbin.common.error.SuccessCode;
import lombok.Getter;

@Getter
public class ApiResTemplate<T> {

    private int status;
    private String message;
    private T data;

    private ApiResTemplate(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResTemplate<T> successResponse(SuccessCode code, T data) {
        return new ApiResTemplate<>(code.getHttpStatusCode(), code.getMessage(), data);
    }

    public static <T> ApiResTemplate<T> successWithNoContent(SuccessCode code) {
        return new ApiResTemplate<>(code.getHttpStatusCode(), code.getMessage(), null);
    }

    public static <T> ApiResTemplate<T> failResponse(ErrorCode code) {
        return new ApiResTemplate<>(code.getHttpStatus(), code.getMessage(), null);
    }
}
