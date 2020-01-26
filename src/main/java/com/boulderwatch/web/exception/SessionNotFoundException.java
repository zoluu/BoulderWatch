package com.boulderwatch.web.exception;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException() {
        super();
    }

    public SessionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionNotFoundException(final String message) {
        super(message);
    }

    public SessionNotFoundException(final Throwable cause) {
        super(cause);
    }
}
