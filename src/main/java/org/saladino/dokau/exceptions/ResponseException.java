package org.saladino.dokau.exceptions;

import lombok.Getter;

@Getter
public class ResponseException extends RuntimeException {

    private final String message;
    private final int code;

    public ResponseException(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
