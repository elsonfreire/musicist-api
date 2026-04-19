package br.com.musicist.modules.user.dto;

import br.com.musicist.common.enums.InstrumentType;
import br.com.musicist.common.enums.LevelType;
import br.com.musicist.modules.user.model.User;

import java.time.LocalDateTime;

public record UserResponse(
    Long id, 
    String username, 
    String email, 
    String bio,     
    LevelType level,
    InstrumentType instrument,
    LocalDateTime createdAt
) {
    public UserResponse(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getBio(), user.getLevel(), user.getInstrument(), user.getCreatedAt());
    }
}
