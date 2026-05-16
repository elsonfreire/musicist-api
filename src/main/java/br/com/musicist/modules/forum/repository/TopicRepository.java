package br.com.musicist.modules.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicist.modules.forum.model.Topic;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {}
