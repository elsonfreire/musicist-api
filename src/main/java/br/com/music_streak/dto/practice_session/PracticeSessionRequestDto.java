package br.com.music_streak.dto.practice_session;

import java.time.LocalDate;

public record PracticeSessionRequestDto (
    Integer durationMinutes,
    String notes,
    LocalDate date
){}
