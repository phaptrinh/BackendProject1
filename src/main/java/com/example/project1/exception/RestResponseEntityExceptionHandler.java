package com.example.project1.exception;

import com.example.project1.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<BaseResponse> handleRecordNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(BaseResponse.error(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(BaseResponse.error(ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }









}
