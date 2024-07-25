package org.saladino.dokau.exceptions;

public class BadRequestException  extends ResponseException {

    public BadRequestException() { super("We were unable to validate your request", 400); }

    public BadRequestException(String message) { super(message, 400); }
}
