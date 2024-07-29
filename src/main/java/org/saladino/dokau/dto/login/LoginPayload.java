package org.saladino.dokau.dto.login;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data @Getter
public class LoginPayload {

    private String username;
    private String email;

    @NotEmpty @NotNull
    private String password;
}
