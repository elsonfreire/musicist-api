package br.com.music_streak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.music_streak.dto.LoginResponseDto;
import br.com.music_streak.entity.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public LoginResponseDto login(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if(!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Wrong password");
        }

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setUsername(user.getUsername());

        return loginResponseDto;
    }

    public User register(String email, String username, String password) {
        String encryptedPassword = passwordEncoder.encode(password);
        
        User newUser = new User(null, email, username, encryptedPassword);
        
        return userRepository.save(newUser);
    }
}
