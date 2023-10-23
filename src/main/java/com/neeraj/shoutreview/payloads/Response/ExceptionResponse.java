package com.neeraj.shoutreview.payloads.Response;

public class ExceptionResponse {
    private String message;
    private String operation;

    public ExceptionResponse(String message,String operation) {
        this.message = message;
        this.operation = operation;
    }
}
