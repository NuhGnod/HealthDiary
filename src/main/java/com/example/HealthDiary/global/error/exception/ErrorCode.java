package com.example.HealthDiary.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // Base
    INVALID_INPUT_VALUE(400, "B4001", " Invalid Input Value"),
    INVALID_TYPE_VALUE(400, "B4002", " Invalid Type Value"),
    ENTITY_NOT_FOUND(400, "B4003", " Entity Not Found"),
    HANDLE_ACCESS_DENIED(403, "B4031", "Access is Denied"),
    METHOD_NOT_ALLOWED(405, "B4051", " Invalid Input Value"),
    INTERNAL_SERVER_ERROR(500, "B5001", "Server Error"),


    // User
    NONE_SESSION_INFORMATION(401, "U4011", "Session information does not exist"),
    INVALID_USER_ID(401, "U4012", "User id is invalid"),
    INVALID_USER_PASSWORD(401, "U4013", "password is invalid"),
    DUPLICATED_USER_ID(401,"U4014", "duplicated id"),
    ;
    private final String code;
    private final String message;
    private final int status;


    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;

    }

}
