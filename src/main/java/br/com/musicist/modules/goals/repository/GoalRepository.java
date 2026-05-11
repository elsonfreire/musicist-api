package br.com.musicist.modules.goals.repository;

import br.com.musicist.modules.goals.model.Goal;
import br.com.musicist.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserAndCreatedAtAfter(User user, LocalDate after);
}
