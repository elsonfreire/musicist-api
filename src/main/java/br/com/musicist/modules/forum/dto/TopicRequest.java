package br.com.musicist.modules.forum.dto;

import br.com.musicist.common.enums.ForumCategoryType;

public record TopicRequest(
    String title,
    ForumCategoryType category,
    String description
) {
    
}
