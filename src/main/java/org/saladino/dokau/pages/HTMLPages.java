package org.saladino.dokau.pages;

public class HTMLPages {

    public static String confirmEmailPage(String token) {

        return  "<html>" +
                "    <body>" +
                "        <h1>Dokau - One place for your project</h1>" +
                "        <p>Welcome to dokau! We received your request to create an account, here's the link:</p>" +
                "        <a href=\"https://www.google.com.br?token=" + token + "\">Register</a>" +
                "    </body>" +
                "</html>";
    }
}
