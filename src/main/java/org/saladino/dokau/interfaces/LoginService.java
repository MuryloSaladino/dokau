package org.saladino.dokau.interfaces;

import org.saladino.dokau.dto.access.LoginPayload;
import org.saladino.dokau.dto.access.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginPayload payload);
}
