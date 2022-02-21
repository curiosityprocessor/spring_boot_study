package com.cp.study.springboot.board;

import java.util.List;
import java.util.Map;

import com.cp.study.springboot.common.Result;
import com.cp.study.springboot.common.CommonConstants.ResultCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("UserBoardService")
public class UserBoardServiceImpl implements BoardService {

    @Autowired
    UserBoardReadMapper userBoardReadMapper;

    @Autowired
    UserBoardWriteMapper userBoardWriteMapper;

    private String mockUserId = "cpBot1";
    
    @Override
    public void insertBoard(BoardDto param) {
        param.setCreateId(mockUserId);
        userBoardWriteMapper.insertBoard(param);
    }
    
    @Override
    public BoardDto selectBoardDetail(int param) {
        BoardDto result = userBoardReadMapper.selectBoardDetail(param);
        if(result == null) {
            log.info("UserBoardService selectBoard: NULL");
            return result;
        }

        BoardDto updateParam = BoardDto.builder()
            .id(result.getId())
            .title(result.getTitle())
            .contents(result.getContents())
            .views(result.getViews() + 1)
            .isDeleted(result.isDeleted())
            .updateId(result.getCreateId()) //TODO replace with id from session
            .build();
        updateBoard(updateParam);
        return result;
    }

    @Override
    public List<BoardDto> selectBoardList() {
        return userBoardReadMapper.selectBoardList();
    }

    @Override
    public void updateBoard(BoardDto param) {
        param.setUpdateId(mockUserId);
        userBoardWriteMapper.updateBoard(param);
    }

    @Override
    public void deleteBoard(int param) {
        userBoardWriteMapper.deleteBoard(param);
    }
    
}
