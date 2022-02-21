package com.cp.study.springboot.board;

public class BoardConstants {
    public static class View {
        public static final String BOARD_LIST = "board/user/userBoardList";
        public static final String BOARD_WRITER = "board/user/userBoardWriter";
        public static final String BOARD_DETAIL = "board/user/userBoardDetail";
    }
    public static class Url {
        public static final String BOARD_LIST = "/board/user/board-list";
        public static final String BOARD_DETAIL = "/board/user/board";
        public static final String BOARD_WRITER = "/board/user/board-writer";
        public static final String BOARD_INSERT = "/board/user/insert";
        public static final String BOARD_UPDATE = "/board/user/update";
        public static final String BOARD_DELETE = "/board/user/delete";
    }

    public static class Error {
        public static final String NOT_EXIST = "존재하지 않는 게시글입니다.";
    }
}
