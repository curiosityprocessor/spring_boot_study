package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.Result;

public interface BoardService {
    
    public void insertBoard(BoardDto param);
    public BoardDto selectBoard(BoardDto param);
    public List<BoardDto> selectBoardList();
    public void updateBoard(BoardDto param);
    public void deleteBoard(BoardDto param);
}
