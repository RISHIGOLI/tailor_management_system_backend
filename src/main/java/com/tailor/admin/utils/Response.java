package com.tailor.admin.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response<T> {
    private Boolean status;
    private Integer statusCode;
    private String message;
    private List<T> data;
    private T singleReturnedItem;

    public Response(Boolean status, Integer statusCode, String message)
    {
        this.setStatus(status);
        this.setStatusCode(statusCode);
        this.setMessage(message);
    }

    public Response(Boolean status, Integer statusCode, String message, T data){
        this.setStatus(status);
        this.setStatusCode(statusCode);
        this.setMessage(message);
        this.setSingleReturnedItem(data);
    }

    public Response(Boolean status, Integer statusCode, String message, List<T> data){
        this.setStatus(status);
        this.setStatusCode(statusCode);
        this.setMessage(message);
        this.setData(data);
    }
}
