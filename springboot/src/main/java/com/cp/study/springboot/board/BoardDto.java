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
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;
}

