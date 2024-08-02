package org.saladino.dokau.services;

import org.saladino.dokau.dto.login.LoginPayload;
import org.saladino.dokau.dto.login.LoginResponse;
import org.saladino.dokau.dto.users.UserEntityResponse;
import org.saladino.dokau.entities.UserEntity;
import org.saladino.dokau.exceptions.NotFoundException;
import org.saladino.dokau.exceptions.UnauthorizedException;
import org.saladino.dokau.interfaces.JwtTokenManager;
import org.saladino.dokau.interfaces.LoginService;
import org.saladino.dokau.repositories.UserEntityRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceDefault implements LoginService {

    private final UserEntityRepository userRepository;
    private final JwtTokenManager jwtTokenManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginServiceDefault(
            UserEntityRepository userRepository,
            JwtTokenManager jwtTokenManager,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public LoginResponse login(LoginPayload payload) {

        var query = userRepository.findByUsernameOrEmail(payload.getUsername(), payload.getEmail());
        if(query.isEmpty()) throw new NotFoundException("Those credentials don't match any user in our database");

        UserEntity user = query.get();

        if(!passwordEncoder.matches(payload.getPassword(), user.getPassword()))
            throw new UnauthorizedException("Wrong password");

        Map<String, Object> claims = new HashMap<>();
        claims.put("admin", user.getAdmin());

        return new LoginResponse(
            new UserEntityResponse(user),
            jwtTokenManager.buildToken(claims, user.getUsername(), user.getId())
        );
    }
}
