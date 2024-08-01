package org.saladino.dokau.controllers;

import jakarta.validation.Valid;
import org.saladino.dokau.dto.login.LoginPayload;
import org.saladino.dokau.dto.login.LoginResponse;
import org.saladino.dokau.interfaces.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(final LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginPayload payload) {
        return ResponseEntity.ok(loginService.login(payload));
    }
}
