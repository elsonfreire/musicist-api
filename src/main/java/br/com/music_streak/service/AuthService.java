package br.com.music_streak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.music_streak.dto.LoginRequestDto;
import br.com.music_streak.dto.LoginResponseDto;
import br.com.music_streak.dto.RegisterRequestDto;
import br.com.music_streak.dto.RegisterResponseDto;
import br.com.music_streak.infra.security.TokenService;
import br.com.music_streak.model.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;
    
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.email())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(!passwordEncoder.matches(loginRequestDto.password(), user.getPasswordHash())) {
            throw new RuntimeException("Wrong password");
        }

        var token = tokenService.generateToken(user);

        return new LoginResponseDto(token);
    }

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        String encryptedPassword = passwordEncoder.encode(registerRequestDto.password());
        
        if(userRepository.findByEmail(registerRequestDto.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User newUser = new User(registerRequestDto.email(), registerRequestDto.username(), encryptedPassword);
        User user = userRepository.save(newUser);

        return new RegisterResponseDto(user.getEmail(), user.getUsername());
    }
}
