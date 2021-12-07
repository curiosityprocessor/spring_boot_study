package com.cp.study.springboot.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBoardWriteMapper {
    void insertBoard(BoardDto param);
}
