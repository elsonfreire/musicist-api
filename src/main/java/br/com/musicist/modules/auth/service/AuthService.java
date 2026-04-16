package br.com.musicist.modules.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.musicist.infra.security.TokenService;
import br.com.musicist.modules.auth.dto.LoginRequest;
import br.com.musicist.modules.auth.dto.LoginResponse;
import br.com.musicist.modules.auth.dto.RegisterRequest;
import br.com.musicist.modules.auth.dto.RegisterResponse;
import br.com.musicist.modules.user.model.User;
import br.com.musicist.modules.user.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;
    
    public LoginResponse login(LoginRequest loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.email())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(!passwordEncoder.matches(loginRequestDto.password(), user.getPasswordHash())) {
            throw new RuntimeException("Wrong password");
        }

        var token = tokenService.generateToken(user);

        return new LoginResponse(token);
    }

    public RegisterResponse register(RegisterRequest registerRequestDto) {
        String encryptedPassword = passwordEncoder.encode(registerRequestDto.password());
        
        if(userRepository.findByEmail(registerRequestDto.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User newUser = new User(registerRequestDto.email(), registerRequestDto.username(), encryptedPassword);
        User user = userRepository.save(newUser);

        return new RegisterResponse(user.getEmail(), user.getUsername());
    }
}
