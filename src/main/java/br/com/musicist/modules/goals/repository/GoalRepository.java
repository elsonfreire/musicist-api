package br.com.musicist.modules.goals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.musicist.modules.goals.model.Goal;
import java.util.List;
import br.com.musicist.modules.user.model.User;


public interface GoalRepository extends JpaRepository<Goal, Long> {
    @Query("""
        SELECT g FROM Goal g
        WHERE g.user = :user
        AND g.status = "PENDING"
    """)
    List<Goal> findAllPendingByUser(User user);
}
