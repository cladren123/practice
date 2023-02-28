package example.jpa.controller;

import example.jpa.board.Board;
import example.jpa.dto.BoardDto;
import example.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
        }
        else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }

    }


    // 아이디로 게시글 하나 조회
    @GetMapping("/getById/{boardId}")
    public ResponseEntity<?> getById(@PathVariable Long boardId) {
        BoardDto boardDto = boardService.getById(boardId);

        if (boardDto != null) {
            return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }


    // 게시글 수정
    @PutMapping("/delete/{boardId}")
    public ResponseEntity<?> delete(@PathVariable BoardDto boardDto) {

        BoardDto boardUpdateDto = boardService.update(boardDto);

        if (boardUpdateDto != null) {
            return new ResponseEntity<BoardDto>(boardUpdateDto, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
        }
    }


    // 게시글 삭제
    @DeleteMapping("/deleteById/{boardId}")
    public void deleteById(@PathVariable Long boardId) {
        boardService.deleteById(boardId);
    }










}
