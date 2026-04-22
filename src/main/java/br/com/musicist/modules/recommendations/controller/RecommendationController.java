package br.com.musicist.modules.recommendations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicist.modules.recommendations.dto.RecommendationResponse;
import br.com.musicist.modules.recommendations.service.RecommendationService;
import br.com.musicist.modules.user.model.User;

@RestController
@RequestMapping("/connections")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendations")
    public ResponseEntity<List<RecommendationResponse>> getRecommendations(
            @AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(recommendationService.getRecommendations(currentUser));
    }
}