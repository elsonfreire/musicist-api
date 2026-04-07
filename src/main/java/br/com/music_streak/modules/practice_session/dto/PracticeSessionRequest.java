package br.com.music_streak.modules.practice_session.dto;

import java.time.LocalDate;

import br.com.music_streak.common.enums.InstrumentType;

public record PracticeSessionRequest (
    Integer durationMinutes,
    InstrumentType instrument,
    String notes,
    LocalDate date
){}
