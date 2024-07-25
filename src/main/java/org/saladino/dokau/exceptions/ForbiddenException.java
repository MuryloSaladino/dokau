package org.saladino.dokau.exceptions;

public class ForbiddenException extends ResponseException {

    public ForbiddenException() { super("You don't have authorization to do that", 403); }

    public ForbiddenException(String message) { super(message, 403); }
}
