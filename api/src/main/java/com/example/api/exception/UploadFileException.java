package com.example.api.exception;

public class UploadFileException extends RuntimeException {
    public UploadFileException(String message) {
        super(message);
    }
 
    public UploadFileException(String message, Throwable reason) {
        super(message, reason);
    }
}
