package br.com.musicist.modules.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicist.modules.auth.dto.LoginRequest;
import br.com.musicist.modules.auth.dto.LoginResponse;
import br.com.musicist.modules.auth.dto.RegisterRequest;
import br.com.musicist.modules.auth.dto.RegisterResponse;
import br.com.musicist.modules.auth.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequestDto) {
        return ResponseEntity.status(201).body(authService.register(registerRequestDto));
    }
    
}
