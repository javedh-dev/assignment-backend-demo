package com.taomish.assignment.jobportal.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseWrapper {
    private String message;
    private Map<String, Object> response=new HashMap<>();

    public HttpStatus setError(Exception e, String message){
        HttpStatus status;
        setMessage(message);
        getResponse().put("error", e.getMessage());
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        return status;
    }
}
