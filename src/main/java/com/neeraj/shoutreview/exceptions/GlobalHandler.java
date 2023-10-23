package com.neeraj.shoutreview.exceptions;

import com.neeraj.shoutreview.payloads.Response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException exp) {
        return new ResponseEntity<>(new ExceptionResponse(exp.getMessage(),"failed"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exp) {
        Map<String,String> mp = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            mp.put(fieldName, message);
        });
        return new ResponseEntity<>(mp,HttpStatus.BAD_REQUEST);
    }
}
