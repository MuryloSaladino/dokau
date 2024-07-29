package org.saladino.dokau.filters;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.saladino.dokau.interfaces.JwtTokenManager;
import org.saladino.dokau.utility.UserSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ValidateTokenFilter extends OncePerRequestFilter {

    private final JwtTokenManager jwtTokenManager;
    private final UserSession userSession;

    public ValidateTokenFilter(final JwtTokenManager jwtTokenManager, final UserSession userSession) {
        this.jwtTokenManager = jwtTokenManager;
        this.userSession = userSession;
    }

    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if(token != null) {
            try {
                token = token.replace("Bearer ", "");
                Claims claims = jwtTokenManager.extractClaims(token);

                userSession.setId(Long.parseLong(claims.getId()));
                userSession.setAdmin(claims.get("admin", Boolean.class));
            }
            catch (RuntimeException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            }
        }

        filterChain.doFilter(request, response);
    }
}
