package br.com.music_streak.modules.practice_session.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.modules.practice_session.dto.PracticeSessionRequestDto;
import br.com.music_streak.modules.practice_session.dto.PracticeSessionResponseDto;
import br.com.music_streak.modules.practice_session.service.PracticeSessionService;
import br.com.music_streak.modules.user.model.User;

@RestController
@RequestMapping("/sessions")
public class PracticeSessionController {

    @Autowired
    private PracticeSessionService practiceSessionService;

    @PostMapping
    public ResponseEntity<PracticeSessionResponseDto> create(
            @RequestBody PracticeSessionRequestDto dto,
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.status(201).body(practiceSessionService.createPracticeSession(dto, currentUser));
    }

    @GetMapping
    public ResponseEntity<List<PracticeSessionResponseDto>> getAllMySessions(
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(practiceSessionService.getPracticeSessionsByUserId(currentUser.getId()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PracticeSessionResponseDto>> getAllUserSessions(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(practiceSessionService.getPracticeSessionsByUserId(userId));
    }
}