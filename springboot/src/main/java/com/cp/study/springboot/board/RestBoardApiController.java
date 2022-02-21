package com.cp.study.springboot.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBoardApiController {
    @Autowired
    @Qualifier("UserBoardService")
    BoardService boardService;

    @GetMapping("/api/board")
    public List<BoardDto> selectBoardList() {
        return boardService.selectBoardList();
    }

    @PostMapping("/api/board/write")
    public String insertBoard(@RequestBody BoardDto param) {
        boardService.insertBoard(param);
        return "redirect:/board";
    }

    @GetMapping("/api/board/{id}")
    public BoardDto selectBoardDetail(@PathVariable("id") int param) {
        return boardService.selectBoardDetail(param);
    }

    @PutMapping("/api/board/{id}")
    public String updateBoard(@RequestBody BoardDto param) {
        boardService.updateBoard(param);
        return "redirect:/board";
    }

    @DeleteMapping("/api/board/{id}")
    public String deleteBoard(@PathVariable("id") int param) {
        boardService.deleteBoard(param);
        return "redirect:/board";
    }
}
