package br.com.music_streak.modules.user.dto;

import br.com.music_streak.modules.user.model.User;

public record UserResponseDto(
    Long id, 
    String username, 
    String email, 
    String bio, 
    Short level, 
    String instrument
) {
    public UserResponseDto(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getBio(), user.getLevel(), user.getInstrument());
    }
}
