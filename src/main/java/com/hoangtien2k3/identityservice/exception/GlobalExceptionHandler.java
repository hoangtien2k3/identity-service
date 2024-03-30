package com.hoangtien2k3.identityservice.exception;

import com.hoangtien2k3.identityservice.dto.response.ApiResponse;
import com.hoangtien2k3.identityservice.exception.EnumConfig.ErrorCode;
import com.hoangtien2k3.identityservice.exception.payload.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<ApiResponse> handlingException(Exception exception) {
        ApiResponse apiResponseError = new ApiResponse();
        apiResponseError.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponseError.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponseError);
    }

    @ExceptionHandler(value = {AppException.class})
    ResponseEntity<ApiResponse> handlingRuntimeException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponseError = new ApiResponse();
        apiResponseError.setCode(errorCode.getCode());
        apiResponseError.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponseError);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    ResponseEntity<ApiResponse> handlingRuntimeException(AccessDeniedException exception) {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(
                        ApiResponse.builder()
                                .code(errorCode.getCode())
                                .message(errorCode.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    ResponseEntity<ApiResponse> handlingValidationException(MethodArgumentNotValidException exception) {
        String enumKey = exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {

        }

        ApiResponse apiResponseError = new ApiResponse();
        apiResponseError.setCode(errorCode.getCode());
        apiResponseError.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponseError);
    }

}
