package com.example.RiderBackend.exception;

public class RiderNotFoundException extends RuntimeException{
    public RiderNotFoundException(Long id){
        super("Could Not Found the Rider with id "+id);
    }
}
