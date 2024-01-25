package ru.dzolotarev.springbootapi.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestExceptionResponse {

    private final String uuid;
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String path;
    private final String code;
    private final String message;

    public RestExceptionResponse(String uuid, Integer status, String path, String code, String message) {
        this.uuid = uuid;
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.path = path;
        this.code = code;
        this.message = message;
    }

    public static RestExceptionResponse of(String uuid, Integer status, String path, String code, String message) {
        return new RestExceptionResponse(uuid, status, path, code, message);
    }
}
