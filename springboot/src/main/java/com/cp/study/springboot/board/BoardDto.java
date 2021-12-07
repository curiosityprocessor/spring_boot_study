package com.cp.study.springboot.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
    private String id;
    private String title;
    private String contents;
    private int views;
    private boolean isDeleted;
    private String createId;
    private LocalDateTime createTime;
    private String updateId;
    private LocalDateTime updateTime;
}

