package br.com.music_streak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.music_streak.dto.LoginRequestDto;
import br.com.music_streak.dto.LoginResponseDto;
import br.com.music_streak.dto.RegisterRequestDto;
import br.com.music_streak.entity.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Wrong password");
        }

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setUsername(user.getUsername());

        return loginResponseDto;
    }

    public User register(RegisterRequestDto registerRequestDto) {
        String encryptedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        
        User newUser = new User(null, registerRequestDto.getEmail(), registerRequestDto.getUsername(), encryptedPassword);
        
        return userRepository.save(newUser);
    }
}
