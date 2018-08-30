package com.first.app.util;
 
public class CryptoException extends Exception {
 
    public CryptoException() {
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}