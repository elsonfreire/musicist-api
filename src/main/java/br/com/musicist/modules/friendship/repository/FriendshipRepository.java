package br.com.musicist.modules.friendship.repository;

import br.com.musicist.common.enums.FriendshipStatusType;
import br.com.musicist.modules.friendship.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    @Query("""
        SELECT f FROM Friendship f
        WHERE (f.requester.id = :a AND f.receiver.id = :b)
           OR (f.requester.id = :b AND f.receiver.id = :a)
    """)
    Optional<Friendship> findBetween(@Param("a") Long a, @Param("b") Long b);

    @Query("""
        SELECT f FROM Friendship f
        WHERE (f.requester.id = :userId OR f.receiver.id = :userId)
          AND f.status = 'ACCEPTED'
    """)
    List<Friendship> findAcceptedFriendships(@Param("userId") Long userId);

    List<Friendship> findByReceiverIdAndStatus(Long receiverId, FriendshipStatusType status);
}
