package com.dbk.stringencoder;

public class StringOutOfRangeException extends RuntimeException {
    public StringOutOfRangeException(){
        super();
    }

    public StringOutOfRangeException(String message){
        super(message);
    }

    public StringOutOfRangeException(Throwable ex, String message){
        super(message, ex);
    }
}
