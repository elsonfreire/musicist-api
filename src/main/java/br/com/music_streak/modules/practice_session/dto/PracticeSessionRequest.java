package br.com.music_streak.modules.practice_session.dto;

import java.time.LocalDate;

public record PracticeSessionRequest (
    Integer durationMinutes,
    String notes,
    LocalDate date
){}
