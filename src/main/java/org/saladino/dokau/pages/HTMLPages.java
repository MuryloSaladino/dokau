package org.saladino.dokau.pages;

import org.saladino.dokau.interfaces.JwtTokenManager;
import org.springframework.stereotype.Component;

@Component
public class HTMLPages {

    private final JwtTokenManager jwtTokenManager;

    public HTMLPages(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    public static String confirmEmailPage() {

        return "";
    }
}
