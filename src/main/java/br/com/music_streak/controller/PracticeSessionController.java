package br.com.music_streak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.dto.practice_session.PracticeSessionRequestDto;
import br.com.music_streak.dto.practice_session.PracticeSessionResponseDto;
import br.com.music_streak.model.User;
import br.com.music_streak.service.PracticeSessionService;

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
}