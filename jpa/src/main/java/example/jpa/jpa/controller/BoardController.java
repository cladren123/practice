package example.jpa.jpa.controller;

import example.jpa.jpa.dto.BoardDto;
import example.jpa.jpa.dto.BoardReplyDto;
import example.jpa.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;


    // 게시글 삽입
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody BoardDto boardDto) {

        System.out.println("board insret 작동");

        BoardDto boardReadDto = boardService.insert(boardDto);
        if (boardReadDto != null) {
            return new ResponseEntity<BoardDto>(boardReadDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }

    }


    // 아이디로 게시글 하나 조회
    @GetMapping("/getById/{boardId}")
    public ResponseEntity<?> getById(@PathVariable Long boardId) {
        BoardDto boardDto = boardService.getById(boardId);

        if (boardDto != null) {
            return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }

    // 게시글 전체 조회
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<BoardDto> boardDtoList = boardService.getAll();

        if (boardDtoList != null) {
            return new ResponseEntity<List<BoardDto>>(boardDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }


    // 게시글 수정
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BoardDto boardDto) {

        BoardDto boardUpdateDto = boardService.update(boardDto);

        if (boardUpdateDto != null) {
            return new ResponseEntity<BoardDto>(boardUpdateDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }


    // 게시글 삭제
    @DeleteMapping("/deleteById/{boardId}")
    public void deleteById(@PathVariable Long boardId) {
        boardService.deleteById(boardId);
    }


    // 게시글 댓글 삽입
    @PostMapping("/reply/insert")
    public ResponseEntity<?> replyInsert(@RequestBody BoardReplyDto boardReplyDto) {
        BoardReplyDto boardReplySaveDto = boardService.replyInsert(boardReplyDto);

        if (boardReplySaveDto != null) {
            return new ResponseEntity<BoardReplyDto>(boardReplySaveDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }

    // 게시글 댓글 편집
    @PutMapping("/reply/update")
    public ResponseEntity<?> replyUpdate(@RequestBody BoardReplyDto boardReplyDto) {
        BoardReplyDto boardReplyUpdateDto = boardService.replyUpdate(boardReplyDto);

        if (boardReplyUpdateDto != null) {
            return new ResponseEntity<BoardReplyDto>(boardReplyUpdateDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }

    // 게시글 댓글 삭제
    @DeleteMapping("/reply/deleteById/{boardReplyId}")
    public void replyDeleteById(@PathVariable Long boardReplyId) {
        boardService.deleteById(boardReplyId);
    }

}