package br.com.musicist.modules.practice_session.dto;

import java.time.LocalDate;

import br.com.musicist.common.enums.InstrumentType;

public record PracticeSessionRequest (
    Integer durationMinutes,
    InstrumentType instrument,
    String notes,
    LocalDate date
){}
