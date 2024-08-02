package org.saladino.dokau.services;

import org.saladino.dokau.interfaces.EmailSender;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements EmailSender {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {

    }
}
