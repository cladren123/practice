package example.jpa.repository;

import example.jpa.Entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long> {

}
