package br.com.musicist.modules.forum.dto;

import java.time.LocalDateTime;

import br.com.musicist.modules.user.dto.UserResponse;

public record CommentRequest(
    Long id,
    String content,
    UserResponse author,
    LocalDateTime createdAt
) {

}
