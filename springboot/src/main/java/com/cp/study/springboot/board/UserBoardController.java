package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.CommonConstants;
import com.cp.study.springboot.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class UserBoardController {

    @Autowired
    @Qualifier("UserBoardService")
    private BoardService boardService;

    private String mockUserId = "cpBot1";
    
    @GetMapping(BoardConstants.Url.BOARDS)
    public ModelAndView getBoards() {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_LIST);
        List<BoardDto> boardList = boardService.selectBoardList();
        mav.addObject(CommonConstants.LIST, boardList);

        return mav;
    }

    @GetMapping(BoardConstants.Url.BOARD_WRITER)
    public ModelAndView getBoardWriter() {
        return new ModelAndView(BoardConstants.View.BOARD_WRITER);
    }

    @PostMapping(BoardConstants.Url.BOARD)
    public ModelAndView postBoard(BoardDto param, ModelMap model) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARDS); //TODO check forward, addAttribute to model
        param.setCreateId(mockUserId);
        param.setUpdateId(mockUserId);
        Result result = boardService.insertBoard(param);
        mav.addObject(CommonConstants.RESULT, result);
        return mav;
    }

    @GetMapping(BoardConstants.Url.BOARD)
    public ModelAndView getBoard(@RequestParam int id) {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_DETAIL);
        BoardDto param = BoardDto.builder().id(id).build();
        mav.addObject(CommonConstants.RESULT, boardService.selectBoard(param));
        return mav;
    }

    @PutMapping(BoardConstants.Url.BOARD)
    public ModelAndView putBoard(@RequestParam BoardDto param) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARDS);
        param.setCreateId(mockUserId);
        param.setUpdateId(mockUserId);
        Result result = boardService.updateBoard(param);
        mav.addObject(CommonConstants.RESULT, result);
        return mav;
    }
}
