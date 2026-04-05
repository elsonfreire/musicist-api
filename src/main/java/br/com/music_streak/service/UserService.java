package br.com.music_streak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.model.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        // TODO: Implement DTO to hide passwordHash on return

        if(user.isEmpty()) {
            return null;
        }

        return user.get(); 
    }
}
