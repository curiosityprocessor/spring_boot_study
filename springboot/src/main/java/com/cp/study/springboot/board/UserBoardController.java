package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping(value = "/board/user")
public class UserBoardController {

    @Autowired
    @Qualifier("UserBoardService")
    private BoardService boardService;
    
    @GetMapping("/boardlist")
    public ModelAndView boardList() {
        ModelAndView mav = new ModelAndView("board/userBoardList");
        List<BoardDto> boardList = boardService.selectBoardList();
        mav.addObject("boardList", boardList);

        return mav;
    }

    @GetMapping("/board-writer")
    public ModelAndView boardWriter() {
        ModelAndView mav = new ModelAndView("board/userBoardWriter");
        return mav;
    }

    @PostMapping("/entry")
    public ModelAndView entry(BoardDto param, ModelMap model) {
        Result result = boardService.insertBoard(param);
        model.addAttribute("result", result);
        return new ModelAndView("redirect:/board/user/boardlist"); //TODO check forward, addAttribute to model
    }
}
