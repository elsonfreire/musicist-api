package br.com.musicist.modules.goals.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicist.modules.goals.dto.GoalResponse;
import br.com.musicist.modules.goals.repository.GoalRepository;
import br.com.musicist.modules.user.model.User;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;
    
    public List<GoalResponse> findAllByUser(User user) {
        return goalRepository.findAllByUser(user)
            .stream()
            .map(goal -> new GoalResponse(goal))
            .collect(Collectors.toList());
    }
}
