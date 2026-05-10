package br.com.musicist.modules.goals.dto;

import br.com.musicist.modules.goals.model.Goal;
import br.com.musicist.modules.user.dto.UserSimplifiedResponse;

public record GoalResponse(
    Long id,
    String title,
    UserSimplifiedResponse userResponse
) {
    public GoalResponse(Goal goal) {
        this(goal.getId(), goal.getTitle(), new UserSimplifiedResponse(goal.getUser()));
    }
}
