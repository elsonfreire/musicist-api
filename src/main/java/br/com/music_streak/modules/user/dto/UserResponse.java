package br.com.music_streak.modules.user.dto;

import br.com.music_streak.common.enums.InstrumentType;
import br.com.music_streak.common.enums.LevelType;
import br.com.music_streak.modules.user.model.User;

public record UserResponse(
    Long id, 
    String username, 
    String email, 
    String bio,     
    LevelType level,
    InstrumentType instrument
) {
    public UserResponse(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getBio(), user.getLevel(), user.getInstrument());
    }
}
