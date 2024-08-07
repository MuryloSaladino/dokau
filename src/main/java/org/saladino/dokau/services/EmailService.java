package org.saladino.dokau.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.saladino.dokau.exceptions.ServerErrorException;
import org.saladino.dokau.interfaces.EmailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailSender {

    @Value("${spring.sendgrid.from}")
    private String senderEmail;

    @Value("${spring.sendgrid.api-key}")
    private String secretKey;


    public void sendEmail(String to, String subject, String text) {
        Email from  = new Email(senderEmail);
        Email toEmail = new Email(to);
        Content content = new Content("text/html", text);
        Mail mail = new Mail(from, subject, toEmail, content);

        SendGrid sg = new SendGrid(secretKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        }
        catch (Exception e) {
            throw new ServerErrorException();
        }
    }
}
