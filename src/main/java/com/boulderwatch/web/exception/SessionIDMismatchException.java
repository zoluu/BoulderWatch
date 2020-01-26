package com.boulderwatch.web.exception;

public class SessionIDMismatchException extends RuntimeException {

    public SessionIDMismatchException() {
        super();
    }

    public SessionIDMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SessionIDMismatchException(final String message) {
        super(message);
    }

    public SessionIDMismatchException(final Throwable cause) {
        super(cause);
    }
}
