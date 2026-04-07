package br.com.music_streak.modules.practice_session.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.music_streak.modules.practice_session.model.PracticeSession;

public record PracticeSessionResponse(
    Long id,
    LocalDate date,
    Integer durationMinutes,
    String notes,
    LocalDateTime createdAt
){
    public PracticeSessionResponse(PracticeSession practiceSession) {
        this(practiceSession.getId(), practiceSession.getDate(), practiceSession.getDurationMinutes(), practiceSession.getNotes(), practiceSession.getCreatedAt());
    }
}