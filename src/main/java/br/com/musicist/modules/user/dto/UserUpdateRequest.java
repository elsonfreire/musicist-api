package br.com.musicist.modules.user.dto;

import java.util.List;

import br.com.musicist.common.enums.InstrumentType;
import br.com.musicist.common.enums.InterestType;
import br.com.musicist.common.enums.LevelType;
import br.com.musicist.common.enums.MusicGenre;

public record UserUpdateRequest(
    String username, 
    InstrumentType instrument, 
    String bio, 
    LevelType level,
    String city,
    String state,
    MusicGenre favoriteGenre,
    List<InterestType> interests
) {}
