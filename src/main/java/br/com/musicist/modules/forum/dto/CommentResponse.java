package br.com.musicist.modules.forum.dto;

import java.time.LocalDateTime;

import br.com.musicist.modules.forum.model.Comment;
import br.com.musicist.modules.user.dto.UserResponse;

public record CommentResponse(
    Long id,
    String content,
    UserResponse author,
    Long topicId,
    LocalDateTime createdAt
) {
    public CommentResponse(Comment comment) {
        this(comment.getId(), comment.getContent(), new UserResponse(comment.getAuthor()), comment.getTopic().getId(), comment.getCreatedAt());
    }

}
