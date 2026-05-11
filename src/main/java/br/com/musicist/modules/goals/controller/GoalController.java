package br.com.musicist.modules.goals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import br.com.musicist.modules.goals.dto.GoalResponse;
import br.com.musicist.modules.goals.service.GoalService;
import br.com.musicist.modules.user.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    private GoalService goalService;
    
    @Value("${gemini.api-key}")
    private String geminiApiKey;
    
    @GetMapping("/generate")
    public String generateGoals() {
        Client client = new Client.Builder().apiKey(geminiApiKey).build();

        String responseLanguage = "PT-BR";
        String prompt = "I want to learn a musical instrument."
                + "Suggest exactly 3 different goals for me that I can complete in one week or less."
                + "The response should be a string array in JSON format." 
                + "The content should be in " + responseLanguage; 

        GenerateContentResponse response = 
            client.models.generateContent(
                "gemini-3-flash-preview", 
                prompt,
                null
            );

        return response.text();
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllMyPendingGoals(@AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(goalService.findAllPendingByUser(currentUser));
    }
}
