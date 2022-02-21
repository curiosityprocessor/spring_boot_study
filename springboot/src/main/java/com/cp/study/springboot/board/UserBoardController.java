package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.CommonConstants;
import com.cp.study.springboot.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserBoardController {

    @Autowired
    @Qualifier("UserBoardService")
    private BoardService boardService;

    @RequestMapping(BoardConstants.Url.BOARD_LIST)
    public ModelAndView selectBoardList() {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_LIST);
        List<BoardDto> boardList = boardService.selectBoardList();
        mav.addObject(CommonConstants.LIST, boardList);
        return mav;
    }

    @RequestMapping(BoardConstants.Url.BOARD_WRITER)
    public ModelAndView boardWriter() {
        return new ModelAndView(BoardConstants.View.BOARD_WRITER);
    }

    @RequestMapping(BoardConstants.Url.BOARD_INSERT)
    public ModelAndView insertBoard(BoardDto param, ModelMap model) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARD_LIST); //TODO check forward, addAttribute to model
        try {
            boardService.insertBoard(param);
        } catch (Exception e) {
            log.error("Exception occurred on boardService.insertBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }

    @RequestMapping(BoardConstants.Url.BOARD_DETAIL)
    public ModelAndView selectBoard(@RequestParam int id) {
        ModelAndView mav = new ModelAndView(BoardConstants.View.BOARD_DETAIL);
        BoardDto result = boardService.selectBoardDetail(id);
        if(result == null) {
            mav.setViewName(CommonConstants.View.ERROR); 
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(BoardConstants.Error.NOT_EXIST).build());
        }
        mav.addObject("board", result);
        return mav;
    }

    @RequestMapping(BoardConstants.Url.BOARD_UPDATE)
    public ModelAndView updateBoard( BoardDto board) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARD_LIST);
        try {
            boardService.updateBoard(board);
        } catch (Exception e) {
            log.error("Exception occurred on boardService.updateBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }

    @RequestMapping(BoardConstants.Url.BOARD_DELETE)
    public ModelAndView deleteBoard(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("redirect:" + BoardConstants.Url.BOARD_LIST);
        try {
            boardService.deleteBoard(id);
        } catch (Exception e) {
            log.error("Exception occurred on boardService.deleteBoard()", e);
            mav.addObject(CommonConstants.RESULT, Result.builder().resultMessage(CommonConstants.Error.TRY_AGAIN).build());
            mav.setViewName(CommonConstants.View.ERROR);
        }
        return mav;
    }
}
