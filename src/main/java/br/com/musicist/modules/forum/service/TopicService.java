package br.com.musicist.modules.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicist.modules.forum.dto.TopicResponse;
import br.com.musicist.modules.forum.repository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<TopicResponse> findAll() {
        return topicRepository.findAll()
            .stream()
            .map(TopicResponse::new)
            .toList();
    }
}
