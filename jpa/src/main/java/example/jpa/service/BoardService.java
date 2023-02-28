package example.jpa.service;


import example.jpa.board.Board;
import example.jpa.board.BoardReply;
import example.jpa.dto.BoardDto;
import example.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;


    // 게시판 삽입
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

    // 게시판 수정
    public BoardDto update(BoardDto boardDto) {
        Board board = boardRepository.getById(boardDto.getId());
        BoardDto boardSetDto = new BoardDto(board);
        return boardSetDto;
    }

    // 게시판 삭제
    public void deleteById(Long boardId) {
        boardRepository.deleteById(boardId);
    }

}
