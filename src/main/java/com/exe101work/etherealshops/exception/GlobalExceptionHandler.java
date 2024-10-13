package com.exe101work.etherealshops.exception;

import com.exe101work.etherealshops.domain.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> handleIdNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(ApiResponse.builder()
                .message(e.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .status(false)
                .build());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    ResponseEntity<ApiResponse> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body(ApiResponse.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.CONFLICT.value())
                        .status(false)
                        .build());
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ApiResponse> runtimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(ApiResponse.builder()
                        .message(e.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .status(false)
                        .build());
    }
}
