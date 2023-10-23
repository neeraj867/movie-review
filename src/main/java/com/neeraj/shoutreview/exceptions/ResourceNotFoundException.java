package com.neeraj.shoutreview.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    public ResourceNotFoundException(String resourceName,String fieldName) {
        super(String.format("%s of this %s is not found",resourceName,fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
