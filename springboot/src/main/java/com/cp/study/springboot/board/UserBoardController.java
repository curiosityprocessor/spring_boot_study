package com.cp.study.springboot.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board/user")
public class UserBoardController {

    @Autowired
    @Qualifier("UserBoardService")
    private BoardService boardService;
    
    @RequestMapping("/boardList")
    public ModelAndView boardList() {
        ModelAndView mav = new ModelAndView("board/boardList");
        List<BoardDto> boardList = boardService.selectBoardList();
        mav.addObject("boardList", boardList);

        return mav;
    }

}
