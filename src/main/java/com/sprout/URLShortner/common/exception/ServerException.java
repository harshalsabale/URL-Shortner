package com.sprout.URLShortner.common.exception;

public class ServerException extends RuntimeException {
    public ServerException() {
        super("Something went wrong!");
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
