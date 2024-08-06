package org.saladino.dokau.exceptions;

public class ServerErrorException extends ResponseException {

    public ServerErrorException() {
        super("Something went wrong in our server. Sorry to disappoint you, try again later.", 500);
    }

    public ServerErrorException(String message) { super(message, 500); }
}
