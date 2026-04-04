package br.com.music_streak.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.dto.LoginRequestDto;
import br.com.music_streak.dto.LoginResponseDto;
import br.com.music_streak.dto.RegisterRequestDto;
import br.com.music_streak.entity.User;
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
        return ResponseEntity.ok(authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequestDto registerRequestDto) {
        User user = authService.register(
            registerRequestDto.getEmail(), 
            registerRequestDto.getUsername(), 
            registerRequestDto.getPassword()
        );
        
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(201).body(user);
    }
    
}
