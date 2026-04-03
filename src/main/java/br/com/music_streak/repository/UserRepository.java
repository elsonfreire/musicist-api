package br.com.music_streak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.music_streak.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
