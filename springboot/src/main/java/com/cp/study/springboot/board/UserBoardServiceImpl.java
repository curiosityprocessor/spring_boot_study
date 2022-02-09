package com.cp.study.springboot.board;

import java.util.List;

import com.cp.study.springboot.common.Result;
import com.cp.study.springboot.common.CommonConstants.ResultCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UserBoardService")
public class UserBoardServiceImpl implements BoardService {

    @Autowired
    UserBoardReadMapper userBoardReadMapper;

    @Autowired
    UserBoardWriteMapper userBoardWriteMapper;

    @Override
    public void insertBoard(BoardDto param) {
        userBoardWriteMapper.insertBoard(param);
    }

    @Override
    public BoardDto selectBoard(BoardDto param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BoardDto> selectBoardList() {
        return userBoardReadMapper.selectBoardList();
    }

    @Override
    public void updateBoard(BoardDto param) {
        userBoardWriteMapper.updateBoard(param);
    }

    @Override
    public void deleteBoard(BoardDto param) {
        userBoardWriteMapper.deleteBoard(param);
    }
    
}
