package com.demo.movieticket.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class DomainException extends RuntimeException {
    private HttpStatus status;

    public DomainException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public DomainException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }
}
