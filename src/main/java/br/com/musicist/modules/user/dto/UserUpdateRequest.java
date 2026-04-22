package br.com.musicist.modules.user.dto;

import br.com.musicist.common.enums.InstrumentType;
import br.com.musicist.common.enums.LevelType;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
        @Size(min = 3, max = 50, message = "Username should be between 3 and 50 characters")
        String username,

        InstrumentType instrument,

        @Size(max = 400, message = "Bio should have a maximum of 400 characters")
        String bio,

        LevelType level
) {}
