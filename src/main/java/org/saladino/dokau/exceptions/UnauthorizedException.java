package org.saladino.dokau.exceptions;

public class UnauthorizedException extends ResponseException {

    public UnauthorizedException() { super("We were unable to authenticate you.", 401); }

    public UnauthorizedException(String message) { super(message, 401); }
}
