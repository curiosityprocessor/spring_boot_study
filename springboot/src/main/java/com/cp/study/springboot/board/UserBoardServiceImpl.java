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
    public Result insertBoard(BoardDto param) {
        userBoardWriteMapper.insertBoard(param);
        return Result.builder().resultCode(ResultCode.SUCCESS).build();
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
