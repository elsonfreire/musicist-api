package br.com.musicist.modules.friendship.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.musicist.common.enums.FriendshipStatus;
import br.com.musicist.modules.friendship.model.Friendship;

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

    List<Friendship> findByReceiverIdAndStatus(Long receiverId, FriendshipStatus status);

    @Query("""
        SELECT f.receiver.id FROM Friendship f WHERE f.requester.id = :userId
        UNION
        SELECT f.requester.id FROM Friendship f WHERE f.receiver.id = :userId
    """)
    List<Long> findConnectedUserIds(@Param("userId") Long userId);
}
