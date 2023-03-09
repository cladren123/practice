package example.jpa.jpa.dto;

import example.jpa.jpa.Entity.BoardReply;
import lombok.Data;

@Data
public class BoardReplyDto {

    private Long id;
    private String boardReplyContent;

    private Long boardId;

    public BoardReplyDto(BoardReply boardReply) {
        this.id = boardReply.getId();
        this.boardReplyContent = boardReply.getBoardReplyContent();
        this.boardId = boardReply.getBoard().getId();
    }

    public BoardReplyDto() {
    }

    public BoardReplyDto(Long id, String boardReplyContent, Long boardId) {
        this.id = id;
        this.boardReplyContent = boardReplyContent;
        this.boardId = boardId;
    }
}
