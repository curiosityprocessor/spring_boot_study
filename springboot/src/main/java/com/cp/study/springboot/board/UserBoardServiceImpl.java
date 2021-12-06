package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserBoardService")
public class UserBoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public Result insertBoard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BoardDto selectBoard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BoardDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public Result updateBoard(BoardDto param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result deleteBoard(BoardDto paranm) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
