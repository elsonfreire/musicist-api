package br.com.music_streak.modules.practice_session.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PracticeSessionResponseDto(
    LocalDate date,
    Integer durationMinutes,
    String notes,
    LocalDateTime createdAt
){}