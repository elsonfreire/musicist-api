package br.com.music_streak.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.dto.practice_session.PracticeSessionRequestDto;
import br.com.music_streak.dto.practice_session.PracticeSessionResponseDto;
import br.com.music_streak.model.PracticeSession;
import br.com.music_streak.model.User;
import br.com.music_streak.repository.PracticeSessionRepository;

@Service
public class PracticeSessionService {

    @Autowired
    private PracticeSessionRepository practiceSessionRepository;

    public List<PracticeSessionResponseDto> getPracticeSessionsByUserId(Long userId) {
        return practiceSessionRepository.findByUserId(userId)
                .stream()
                .map(session -> new PracticeSessionResponseDto(
                        session.getId(),
                        session.getUser().getId(),
                        session.getDate(),
                        session.getDurationMinutes(),
                        session.getNotes(),
                        session.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    public PracticeSessionResponseDto createPracticeSession(PracticeSessionRequestDto requestDto, User user) {
        PracticeSession practiceSession = new PracticeSession(requestDto.durationMinutes(), requestDto.notes(), requestDto.date(), user);
        
        PracticeSession savedSession = practiceSessionRepository.save(practiceSession);

        return new PracticeSessionResponseDto(
                savedSession.getId(),
                savedSession.getUser().getId(),
                savedSession.getDate(),
                savedSession.getDurationMinutes(),
                savedSession.getNotes(),
                savedSession.getCreatedAt()
        );
    }
}