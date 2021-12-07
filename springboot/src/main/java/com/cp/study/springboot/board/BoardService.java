package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.Result;

public interface BoardService {
    
    public Result insertBoard(BoardDto param);
    public BoardDto selectBoard(BoardDto param);
    public List<BoardDto> selectBoardList();
    public Result updateBoard(BoardDto param);
    public Result deleteBoard(BoardDto paranm);
}
