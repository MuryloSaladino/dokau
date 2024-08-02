package org.saladino.dokau.interfaces;

public interface EmailSender {
    void sendEmail(String to, String subject, String body);
}
