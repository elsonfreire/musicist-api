package br.com.music_streak.modules.user.dto;

import br.com.music_streak.common.enums.InstrumentType;
import br.com.music_streak.common.enums.LevelType;

public record UserUpdateRequest(String username, InstrumentType instrument, String bio, LevelType level) {
}
