package br.com.music_streak.dto.user;

import br.com.music_streak.model.User;

public record UserResponse(
    Long id, 
    String username, 
    String email, 
    String bio, 
    Short level, 
    String instrument
) {
    public UserResponse(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getBio(), user.getLevel(), user.getInstrument());
    }
}
