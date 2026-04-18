package br.com.musicist.modules.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicist.modules.forum.dto.TopicResponse;
import br.com.musicist.modules.forum.service.TopicService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/forum/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;
    
    @GetMapping
    public ResponseEntity<List<TopicResponse>> getTopics() {
        return ResponseEntity.ok().body(topicService.findAll());
    }
}
