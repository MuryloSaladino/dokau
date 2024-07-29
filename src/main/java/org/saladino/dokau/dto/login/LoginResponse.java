package org.saladino.dokau.dto.login;

import org.saladino.dokau.dto.users.UserEntityResponse;

public record LoginResponse(
    UserEntityResponse user,
    String token
) {}
