package br.com.music_streak.modules.practice_session.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PracticeSessionResponse(
    Long id,
    LocalDate date,
    Integer durationMinutes,
    String notes,
    LocalDateTime createdAt
){}