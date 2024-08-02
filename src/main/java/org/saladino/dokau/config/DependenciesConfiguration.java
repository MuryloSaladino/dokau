package org.saladino.dokau.config;

import org.saladino.dokau.interfaces.JwtTokenManager;
import org.saladino.dokau.services.JwtTokenManagerService;
import org.saladino.dokau.utility.UserSession;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DependenciesConfiguration {

    // UTILITY BEANS

    @Bean @Scope
    JwtTokenManager jwtTokenManager() { return new JwtTokenManagerService(); }

    @Bean @Scope
    BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(11); }


    // SESSION BEANS

    @Bean @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserSession userSession() { return new UserSession(); }
}
