package br.com.music_streak.service;

import java.util.List;
import java.util.Optional;

import br.com.music_streak.dto.user.UpdateUserRequest;
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
        if(user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    public User update(Long id, UpdateUserRequest userUpdated) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userUpdated.getUsername() != null) user.setUsername(userUpdated.getUsername());
        if (userUpdated.getInstrument() != null) user.setInstrument(userUpdated.getInstrument());
        if (userUpdated.getBio() != null) user.setBio(userUpdated.getBio());
        if (userUpdated.getLevel() != null) user.setLevel(userUpdated.getLevel());

        return userRepository.save(user);
    }

}
