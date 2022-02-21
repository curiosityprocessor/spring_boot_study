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

    public static class Url {
        public static final String ROOT = "/";
    }
    
    public static class View {
        public static final String ERROR = "/error";
        
    }

    public static final String RESULT = "result";
    public static final String LIST = "list";
    public static final String SYSTEM = "SYSTEM";
    public static class Error {
        public static final String TRY_AGAIN = "다시 시도해주세요.";
    }
}
