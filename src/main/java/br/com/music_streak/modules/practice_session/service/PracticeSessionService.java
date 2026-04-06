package br.com.music_streak.modules.practice_session.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.modules.practice_session.dto.PracticeSessionRequest;
import br.com.music_streak.modules.practice_session.dto.PracticeSessionResponse;
import br.com.music_streak.modules.practice_session.model.PracticeSession;
import br.com.music_streak.modules.practice_session.repository.PracticeSessionRepository;
import br.com.music_streak.modules.user.model.User;
import br.com.music_streak.modules.user.service.UserService;

@Service
public class PracticeSessionService {

    @Autowired
    private PracticeSessionRepository practiceSessionRepository;
    @Autowired
    private UserService userService;

    public List<PracticeSessionResponse> getPracticeSessionsByUserId(Long userId) {
        return practiceSessionRepository.findByUserId(userId)
                .stream()
                .map(session -> new PracticeSessionResponse(
                        session.getDate(),
                        session.getDurationMinutes(),
                        session.getNotes(),
                        session.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    public PracticeSessionResponse createPracticeSession(PracticeSessionRequest requestDto, User user) {
        PracticeSession practiceSession = new PracticeSession(requestDto.durationMinutes(), requestDto.notes(), requestDto.date(), user);
        PracticeSession savedSession = practiceSessionRepository.save(practiceSession);

        userService.resetStreak(user.getId());
        userService.incrementStreak(user.getId());

        return new PracticeSessionResponse(
                savedSession.getDate(),
                savedSession.getDurationMinutes(),
                savedSession.getNotes(),
                savedSession.getCreatedAt()
        );
    }
}