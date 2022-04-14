package com.padaria.exception.request;

public class EntityBadRequestException extends RuntimeException {

    public EntityBadRequestException(String msg){
        super(msg);
    }

}
