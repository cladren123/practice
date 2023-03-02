package example.jpa.dto;


import example.jpa.Entity.Board;
import example.jpa.Entity.BoardReply;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


// 게시글 입력 DTO



@Data
public class BoardDto {

    private Long id;

    private String boardTitle;

    // 게시글의 내용
    private String boardContent;

    private List<BoardReply> boardReplyList = new ArrayList<>();

    public BoardDto() {
    }

    public BoardDto(Long id, String boardTitle, String boardContent, List<BoardReply> boardReplyList) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardReplyList = boardReplyList;
    }

    public BoardDto(Board board) {
        this.id = board.getId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.boardReplyList = board.getBoardReplyList();
    }
}
