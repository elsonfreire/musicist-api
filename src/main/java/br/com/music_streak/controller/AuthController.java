package br.com.music_streak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.dto.auth.LoginRequestDto;
import br.com.music_streak.dto.auth.LoginResponseDto;
import br.com.music_streak.dto.auth.RegisterRequestDto;
import br.com.music_streak.dto.auth.RegisterResponseDto;
import br.com.music_streak.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return ResponseEntity.status(201).body(authService.register(registerRequestDto));
    }
    
}
