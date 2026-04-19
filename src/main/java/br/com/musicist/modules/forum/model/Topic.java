package br.com.musicist.modules.forum.model;

import java.time.LocalDateTime;

import br.com.musicist.common.enums.ForumCategoryType;
import br.com.musicist.modules.forum.dto.TopicRequest;
import br.com.musicist.modules.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ForumCategoryType category;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Topic(String title, ForumCategoryType category, String description, User user) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.user = user;
    }
}
