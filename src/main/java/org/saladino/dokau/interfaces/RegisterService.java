package org.saladino.dokau.interfaces;

public interface RegisterService {
    void register(String email);
    void sendConfirmationEmail(String email);
}
