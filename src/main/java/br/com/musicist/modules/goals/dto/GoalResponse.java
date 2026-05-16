package br.com.musicist.modules.goals.dto;

import br.com.musicist.modules.goals.model.Goal;

import java.util.UUID;

public record GoalResponse(UUID id, String title) {
  public GoalResponse(Goal goal) {
    this(goal.getId(), goal.getTitle());
  }
}
