package org.saladino.dokau.interfaces;

import org.saladino.dokau.dto.access.RegisterPayload;
import org.saladino.dokau.dto.users.UserEntityResponse;

public interface RegisterService {
    void preRegister(String email);
    void sendConfirmationEmail(String email);
    UserEntityResponse register(RegisterPayload payload, String email);
}
