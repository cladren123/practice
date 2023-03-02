package example.jpa.repository;

import example.jpa.Entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByBoardTitleOrBoardContentContaining(String BoardTitle, String BoardContent, Pageable pageable);


}
