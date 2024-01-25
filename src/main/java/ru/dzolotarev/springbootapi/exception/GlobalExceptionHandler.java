package ru.dzolotarev.springbootapi.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
////Does not work!!
//    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT) // 504
//    @ExceptionHandler(TransactionTimedOutException.class)
//    public RestExceptionResponse handleServiceGatewayTimeoutException(TransactionTimedOutException eexception,
//                                                                      HttpServletRequest servletRequest) {
//
//        String processKey = UUID.randomUUID().toString();
//        log.warn("Service error. Status: uuid: {}, message: {}", processKey, eexception.getMessage());
//
//        return RestExceptionResponse.of(processKey,
//                HttpStatus.GATEWAY_TIMEOUT.value(),
//                servletRequest.getRequestURI(),
//                "123",
//                eexception.getMessage());
//    }

    @ExceptionHandler(Exception.class) // 500 ?
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestExceptionResponse handleAllUncaughtException(Exception exception, HttpServletRequest servletRequest) {

        String processKey = UUID.randomUUID().toString();
        log.warn("Service error. Status: uuid: {}, message: {}", processKey, exception.getMessage());

        return RestExceptionResponse.of(processKey,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                servletRequest.getRequestURI(),
                "678",
                exception.getMessage());
    }
}

