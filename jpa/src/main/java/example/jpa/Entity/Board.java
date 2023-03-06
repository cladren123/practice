package example.jpa.Entity;


import example.jpa.dto.BoardDto;
import lombok.Data;

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
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardReply> boardReplyList = new ArrayList<>();

    public Board() {
    }

    public Board(Long id, String boardTitle, String boardContent, List<BoardReply> boardReplyList) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardReplyList = boardReplyList;
    }

    // DTO으로 생성하기
    public Board(BoardDto boardDto) {
        this.id = boardDto.getId();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }

    // DTO로 수정하기
    public void modifyBoard(BoardDto boardDto) {
        this.id = boardDto.getId();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }
}