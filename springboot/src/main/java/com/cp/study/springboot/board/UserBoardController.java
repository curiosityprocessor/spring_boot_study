package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.CommonConstants;
import com.cp.study.springboot.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserBoardController {

    @Autowired
    @Qualifier("UserBoardService")
    private BoardService boardService;

    private String mockUserId = "cpBot1";
    
    @GetMapping(BoardConstants.Url.BOARDS)
    public ModelAndView boardList() {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_LIST);
        List<BoardDto> boardList = boardService.selectBoardList();
        mav.addObject(CommonConstants.LIST, boardList);
        return mav;
    }

    @GetMapping(BoardConstants.Url.BOARD_WRITER)
    public ModelAndView boardWriter() {
        return new ModelAndView(BoardConstants.View.BOARD_WRITER);
    }

    @PostMapping(BoardConstants.Url.BOARD)
    public ModelAndView insertBoard(BoardDto param, ModelMap model) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARDS); //TODO check forward, addAttribute to model
        param.setCreateId(mockUserId);
        param.setUpdateId(mockUserId);
        try {
            boardService.insertBoard(param);
        } catch (Exception e) {
            log.error("Exception occurred on boardService.insertBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }

    @GetMapping(BoardConstants.Url.BOARD)
    public ModelAndView selectBoard(@RequestParam int id) {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_DETAIL);
        BoardDto param = BoardDto.builder().id(id).build();
        mav.addObject(CommonConstants.RESULT, boardService.selectBoard(param));
        return mav;
    }

    @PutMapping(BoardConstants.Url.BOARD)
    public ModelAndView updateBoard(@RequestParam BoardDto param) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARDS);
        param.setUpdateId(mockUserId);
        try {
            boardService.updateBoard(param);            
        } catch (Exception e) {
            log.error("Exception occurred on boardService.updateBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }

    @DeleteMapping(BoardConstants.Url.BOARD)
    public ModelAndView deleteBoard(@RequestParam BoardDto param) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARDS);
        param.setUpdateId(mockUserId);
        try {
            boardService.deleteBoard(param);
        } catch (Exception e) {
            log.error("Exception occurred on boardService.deleteBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }
}
