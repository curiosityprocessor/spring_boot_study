package com.cp.study.springboot.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBoardReadMapper {

    List<BoardDto> selectBoardList();

    BoardDto selectBoardDetail(int param);
}
