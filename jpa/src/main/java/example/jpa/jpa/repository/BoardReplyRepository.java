package example.jpa.jpa.repository;

import example.jpa.jpa.Entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long> {
}
