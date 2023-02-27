package example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardRepository, Long> {
}
