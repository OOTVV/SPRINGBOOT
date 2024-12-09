package com.igrus.ootw.apipayload.exceptions.validation;

import com.igrus.ootw.apipayload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionHandler {

    // PostNotFoundException 예외를 처리
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handlePostNotFoundException(PostNotFoundException ex) {
        // ApiResponse를 실패로 반환 (isSuccess: false)
        ApiResponse<Object> errorResponse = ApiResponse.onFailure("POST_NOT_FOUND", ex.getMessage());

        // 404 상태 코드와 함께 오류 응답을 반환
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

