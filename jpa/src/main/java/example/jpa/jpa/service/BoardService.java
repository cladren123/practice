package example.jpa.jpa.service;

import example.jpa.jpa.Entity.Board;
import example.jpa.jpa.Entity.BoardReply;
import example.jpa.jpa.dto.BoardDto;
import example.jpa.jpa.dto.BoardReplyDto;
import example.jpa.jpa.repository.BoardReplyRepository;
import example.jpa.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    // repository 의존성 주입
    private final BoardRepository boardRepository;
    private final BoardReplyRepository boardReplyRepository;


    // 게시글 삽입
    public BoardDto insert(BoardDto boardDto) {
        Board board = new Board(boardDto);
        Board save = boardRepository.save(board);
        BoardDto boardReadDto = new BoardDto(save);
        return boardReadDto;
    }


    // 게시글 하나 조회
    public BoardDto getById(Long boardId) {
        Board board = boardRepository.getById(boardId);
        BoardDto boardDto = new BoardDto(board);
        return boardDto;
    }

    // 게시글 전체 조회
    public List<BoardDto> getAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boardList) {
            boardDtoList.add(new BoardDto(board));
        }
        return boardDtoList;
    }

    // 게시글 수정
    public BoardDto update(BoardDto boardDto) {
        Board board = boardRepository.getById(boardDto.getId());
        board.modifyBoard(boardDto);
        BoardDto boardSetDto = new BoardDto(board);
        return boardSetDto;
    }

    // 게시글 삭제
    public void deleteById(Long boardId) {
        boardRepository.deleteById(boardId);
    }


    // 게시글 댓글 작성
    public BoardReplyDto replyInsert(BoardReplyDto boardReplyDto) {
        Board board = boardRepository.getById(boardReplyDto.getBoardId());
        BoardReply boardReply = new BoardReply(boardReplyDto, board);
        BoardReply save = boardReplyRepository.save(boardReply);
        BoardReplyDto saveDto = new BoardReplyDto(save);

        return saveDto;
    }

    // 게시글 댓글 변경하기
    public BoardReplyDto replyUpdate(BoardReplyDto boardReplyDto) {
        BoardReply boardReply = boardReplyRepository.getById(boardReplyDto.getId());
        boardReply.modify(boardReplyDto);
        return new BoardReplyDto(boardReply);
    }

    // 게시글 댓글 삭제
    public void replyDeleteById(Long boardReplyId) {
        boardReplyRepository.deleteById(boardReplyId);
    }
}