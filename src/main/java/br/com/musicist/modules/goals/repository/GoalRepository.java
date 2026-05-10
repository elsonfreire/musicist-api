package br.com.musicist.modules.goals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicist.modules.goals.model.Goal;
import java.util.List;
import br.com.musicist.modules.user.model.User;


public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findAllByUser(User user);
}
