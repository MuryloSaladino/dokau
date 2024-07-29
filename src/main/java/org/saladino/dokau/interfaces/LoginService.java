package org.saladino.dokau.interfaces;

import org.saladino.dokau.dto.login.LoginPayload;
import org.saladino.dokau.dto.login.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginPayload payload);
}
