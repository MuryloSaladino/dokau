package org.saladino.dokau.interfaces;

import io.jsonwebtoken.Claims;
import org.saladino.dokau.exceptions.UnauthorizedException;

import java.util.Map;

public interface JwtTokenManager {
    Claims extractClaims(String token) throws UnauthorizedException;
    String buildToken(Map<String, Object> claims, String subject, Long userId);
}
