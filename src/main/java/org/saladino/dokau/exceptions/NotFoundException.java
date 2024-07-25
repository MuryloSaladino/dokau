package org.saladino.dokau.exceptions;

public class NotFoundException extends ResponseException {

    public NotFoundException() { super("Entity or service not found", 404); }

    public NotFoundException(String message) { super(message, 404); }
}
