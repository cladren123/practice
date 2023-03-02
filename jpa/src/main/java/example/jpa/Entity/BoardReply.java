package example.jpa.Entity;


import example.jpa.dto.BoardReplyDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_reply_id")
    private Long id;

    private String boardReplyContent;


    // 연관관계 설정
    // 1:N 중 N의 입장일 때 설정 방법입니다.
    // JoinColumn의 name은 1:N 중 1의 Class의 id 명 입니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public BoardReply() {
    }

    // 댓글 등록을 위한 생성자 생성
    public BoardReply(BoardReplyDto boardReplyDto, Board board) {
        this.id = boardReplyDto.getId();
        this.boardReplyContent = boardReplyDto.getBoardReplyContent();
        this.board = board;
    }

    public BoardReply(Long id, String boardReplyContent, Board board) {
        this.id = id;
        this.boardReplyContent = boardReplyContent;
        this.board = board;
    }
}
