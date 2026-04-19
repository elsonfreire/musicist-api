package br.com.musicist.modules.forum.dto;

import br.com.musicist.common.enums.ForumCategoryType;
import br.com.musicist.modules.forum.model.Topic;
import br.com.musicist.modules.user.dto.UserResponse;

public record TopicResponse(
    Long id,
    String title,
    ForumCategoryType category,
    String description,
    UserResponse user
) {
    public TopicResponse(Topic topic) {
        this(topic.getId(), topic.getTitle(),topic.getCategory(), topic.getDescription(), new UserResponse(topic.getUser()));
    }

}
