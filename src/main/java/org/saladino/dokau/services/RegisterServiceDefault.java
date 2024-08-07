package org.saladino.dokau.services;

import org.saladino.dokau.entities.RegisterEntity;
import org.saladino.dokau.exceptions.NotFoundException;
import org.saladino.dokau.interfaces.EmailSender;
import org.saladino.dokau.interfaces.JwtTokenManager;
import org.saladino.dokau.interfaces.RegisterService;
import org.saladino.dokau.pages.HTMLPages;
import org.saladino.dokau.repositories.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceDefault implements RegisterService {

    private final RegisterRepository registerRepository;
    private final JwtTokenManager jwtTokenManager;
    private final EmailSender emailSender;

    public RegisterServiceDefault(
            final RegisterRepository registerRepository,
            final JwtTokenManager jwtTokenManager,
            final EmailSender emailSender
    ) {
        this.registerRepository = registerRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.emailSender = emailSender;
    }


    @Override
    public void register(String email) {
        registerRepository.save(new RegisterEntity(email));
    }

    @Override
    public void sendConfirmationEmail(String email) {
        var query = registerRepository.findByEmail(email);
        if(query.isEmpty()) throw new NotFoundException("That email has not been registered");

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        String token = jwtTokenManager.buildToken(claims, "register", query.get().getId());

        emailSender.sendEmail(email, "Confirmation email", HTMLPages.confirmEmailPage(token));
    }
}
