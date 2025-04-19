package com.bms.centralapi.central.api.excepions;

public class UnAuthorizedException  extends RuntimeException{
    public UnAuthorizedException(String message){
        super(message);
    }

}
