package com.padaria.exception.request;

public class EntityInternalServerErrorException extends RuntimeException {

    public EntityInternalServerErrorException(String msg){
        super(msg);
    }

}
