package org.saladino.dokau.services;

import org.saladino.dokau.dto.access.RegisterPayload;
import org.saladino.dokau.entities.PreRegisterEntity;
import org.saladino.dokau.exceptions.NotFoundException;
import org.saladino.dokau.interfaces.EmailSender;
import org.saladino.dokau.interfaces.JwtTokenManager;
import org.saladino.dokau.interfaces.RegisterService;
import org.saladino.dokau.pages.HTMLPages;
import org.saladino.dokau.repositories.PreRegisterRepository;
import org.saladino.dokau.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RegisterServiceDefault implements RegisterService {

    private final PreRegisterRepository preRegisterRepository;
    private final JwtTokenManager jwtTokenManager;
    private final EmailSender emailSender;
    private final UserRepository userRepository;

    public RegisterServiceDefault(
            final PreRegisterRepository preRegisterRepository,
            final JwtTokenManager jwtTokenManager,
            final EmailSender emailSender,
            final UserRepository userRepository
    ) {
        this.preRegisterRepository = preRegisterRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.emailSender = emailSender;
        this.userRepository = userRepository;
    }


    @Override
    public void preRegister(String email) {
        var query = preRegisterRepository.findByEmail(email);
        if(query.isEmpty()) {
            preRegisterRepository.save(new PreRegisterEntity(email));
        }
    }

    @Override
    public void sendConfirmationEmail(String email) {
        var query = preRegisterRepository.findByEmail(email);
        if(query.isEmpty()) throw new NotFoundException("That email has not been registered");

        String token = jwtTokenManager.buildToken(new HashMap<>(), email, query.get().getId());

        emailSender.sendEmail(email, "Confirmation email", HTMLPages.confirmEmailPage(token));
    }

    @Override
    public void register(RegisterPayload payload, String token) {
        var claims = jwtTokenManager.extractClaims(token.replace("Bearer ", ""));
        var query = preRegisterRepository.findByEmail(claims.getSubject());
        if(query.isEmpty()) throw new NotFoundException("Pre register not found in our database");

        preRegisterRepository.delete(query.get());
        userRepository.save( payload.getUser(claims.getSubject()) );
    }
}
