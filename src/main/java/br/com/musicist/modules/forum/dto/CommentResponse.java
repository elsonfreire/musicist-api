package br.com.musicist.modules.forum.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.musicist.modules.forum.model.Comment;
import br.com.musicist.modules.user.dto.UserSimplifiedResponse;

public record CommentResponse(
    UUID id, String content, UserSimplifiedResponse author, UUID topicId, LocalDateTime createdAt) {
  public CommentResponse(Comment comment) {
    this(
        comment.getId(),
        comment.getContent(),
        new UserSimplifiedResponse(comment.getAuthor()),
        comment.getTopic().getId(),
        comment.getCreatedAt());
  }
}
