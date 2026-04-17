package br.com.musicist.modules.user.dto;

import br.com.musicist.common.enums.InstrumentType;
import br.com.musicist.common.enums.LevelType;

public record UserUpdateRequest(String username, InstrumentType instrument, String bio, LevelType level) {
}
