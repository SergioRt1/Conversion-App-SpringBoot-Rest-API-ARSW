package com.example.parcial.services;

public class ConvertException extends Exception{

    public ConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertException(String message) {
        super(message);
    }

}