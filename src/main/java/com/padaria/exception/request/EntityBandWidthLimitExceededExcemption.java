package com.padaria.exception.request;

public class EntityBandWidthLimitExceededExcemption extends  RuntimeException {

    public EntityBandWidthLimitExceededExcemption(String msg){
        super(msg);
    }

}
