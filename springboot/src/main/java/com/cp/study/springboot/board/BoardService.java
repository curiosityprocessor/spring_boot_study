package com.cp.study.springboot.board;

import java.util.List;

public interface BoardService {
    
    public void insertBoard(BoardDto param);

    public BoardDto selectBoardDetail(int id);

    public List<BoardDto> selectBoardList();

    public void updateBoard(BoardDto param);

    public void deleteBoard(int param);
    
}
