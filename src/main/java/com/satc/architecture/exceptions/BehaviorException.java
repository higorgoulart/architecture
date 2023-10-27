package com.satc.architecture.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class BehaviorException extends RuntimeException {
    public BehaviorException() {
        super();
    }

    public BehaviorException(final String message) {
        super(message);
    }

    public BehaviorException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
