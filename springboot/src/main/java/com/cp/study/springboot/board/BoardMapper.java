package com.cp.study.springboot.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList();
    
}
