package br.com.music_streak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.entity.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
