package com.hoangtien2k3.identityservice.exception.EnumConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized"),
    USER_EXISTED(409, "User existed, please again"),
    NOT_FOUND(404, "Not Found"),
    INVALID_KEY(1001, "Invalid message key"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    USERNAME_INVALID(400, "Username must be at least 3 character"),
    PASSWORD_INVALID(400, "Password must be at least 8 character"),
    USER_NOT_EXITSTED(404, "User not exitsted"),
    UNAUTHENTICATED(401, "Unauthenticated");

    private final int code;
    private final String message;
}
