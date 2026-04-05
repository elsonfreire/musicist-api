package br.com.music_streak.dto.practice_session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PracticeSessionResponseDto(
    Long id,
    LocalDate date,
    Integer durationMinutes,
    String notes,
    LocalDateTime createdAt
){}