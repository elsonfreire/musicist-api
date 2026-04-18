package br.com.musicist.modules.forum.dto;

import br.com.musicist.modules.forum.model.Topic;

public record TopicResponse(
    Long id,
    String title,
    String description,
    Long userId
) {
    public TopicResponse(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getDescription(), topic.getUser().getId());
    }

}
