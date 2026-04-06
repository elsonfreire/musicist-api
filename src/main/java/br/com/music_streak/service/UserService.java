package br.com.music_streak.service;

import java.util.List;

import br.com.music_streak.dto.user.UpdateUserRequest;
import br.com.music_streak.dto.user.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.model.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<UserResponse> findAll() {
        return userRepository.findAll()
            .stream()
            .map(UserResponse::new)
            .toList();
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(user);
    }

    public UserResponse update(Long id, UpdateUserRequest userUpdated) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(userUpdated.username() != null) {
            validateUsername(userUpdated.username());
            user.setUsername(userUpdated.username());
        }

        if(userUpdated.instrument() != null) user.setInstrument(userUpdated.instrument());
        if(userUpdated.bio() != null) user.setBio(userUpdated.bio());
        if(userUpdated.level() != null) user.setLevel(userUpdated.level());

        User newUser = userRepository.save(user);

        return new UserResponse(newUser);
    }

    private void validateUsername(String username) {
        if(userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
    }
}
