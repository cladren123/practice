package example.jpa.service;


import example.jpa.Entity.Board;
import example.jpa.Entity.BoardReply;
import example.jpa.dto.BoardDto;
import example.jpa.dto.BoardReplyDto;
import example.jpa.repository.BoardReplyRepository;
import example.jpa.repository.BoardRepository;
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
    public BoardReply replyInsert(BoardReplyDto boardReplyDto) {
        Board board = boardRepository.getById(boardReplyDto.getBoardId());
        BoardReply boardReply = new BoardReply(boardReplyDto, board);
        BoardReply save = boardReplyRepository.save(boardReply);

        return save;
    }

    // 게시글 댓글 변경하기
    public BoardReply replyUpdate(BoardReplyDto boardReplyDto) {

    }


}
