package br.com.musicist.modules.user.dto;

import br.com.musicist.modules.user.model.User;

import java.util.UUID;

public record UserSimplifiedResponse(UUID id, String username) {
  public UserSimplifiedResponse(User user) {
    this(user.getId(), user.getUsername());
  }
}
