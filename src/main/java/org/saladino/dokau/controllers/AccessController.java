package org.saladino.dokau.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.saladino.dokau.dto.access.LoginPayload;
import org.saladino.dokau.dto.access.LoginResponse;
import org.saladino.dokau.interfaces.LoginService;
import org.saladino.dokau.interfaces.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api")
public class AccessController {

    private final LoginService loginService;
    private final RegisterService registerService;

    public AccessController(
            final LoginService loginService,
            RegisterService registerService
    ) {
        this.loginService = loginService;
        this.registerService = registerService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginPayload payload) {
        return ResponseEntity.ok(loginService.login(payload));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createResgister(@Email @RequestParam String email) {
        registerService.register(email);
        registerService.sendConfirmationEmail(email);
        return ResponseEntity.noContent().build();
    }
}
