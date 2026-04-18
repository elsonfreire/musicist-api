package br.com.musicist.modules.forum.dto;

import br.com.musicist.modules.forum.model.Topic;
import br.com.musicist.modules.user.dto.UserResponse;

public record TopicResponse(
    Long id,
    String title,
    String description,
    UserResponse user
) {
    public TopicResponse(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getDescription(), new UserResponse(topic.getUser()));
    }

}
