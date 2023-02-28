package example.jpa.board;


import example.jpa.dto.BoardDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    // 게시글의 제목
    private String boardTitle;

    // 게시글의 내용
    private String boardContent;

    // mappedBy 의 대상은 1:N에서 N의 클래스에 ManyToOne의 필드명 입니다.
    @OneToMany(mappedBy = "board")
    private List<BoardReply> boardReplyList = new ArrayList<>();

    public Board() {
    }

    public Board(Long id, String boardTitle, String boardContent, List<BoardReply> boardReplyList) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardReplyList = boardReplyList;
    }

    // 입력DTO
    public Board(BoardDto boardDto) {
        this.id = boardDto.getId();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }



}
