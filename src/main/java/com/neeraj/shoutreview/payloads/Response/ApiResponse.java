package com.neeraj.shoutreview.payloads.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private String operation;

    public ApiResponse(String message, String operation) {
        super();
        this.message = message;
        this.operation = operation;
    }
}
