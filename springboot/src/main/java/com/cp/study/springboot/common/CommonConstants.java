package com.cp.study.springboot.common;

import lombok.Getter;

public class CommonConstants {
    public enum ResultCode {
        SUCCESS("00"), 
        WAITING("01"), 
        FAIL("99");
    
        @Getter
        private final String code;
    
        ResultCode(String code){
            this.code = code;
        }
    
    }

    public static class Urls {
        public static final String ROOT = "/";
    }

    public static final String RESULT = "result";
    public static final String LIST = "list";
}
