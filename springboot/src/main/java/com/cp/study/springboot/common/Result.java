package com.cp.study.springboot.common;

import lombok.Data;
import lombok.Getter;
import lombok.Builder.Default;

@Data
public class Result {
    private ResultCode resultCode;
    private String resultMessage;
}

enum ResultCode {
    SUCCESS("00"), 
    WAITING("01"), 
    FAIL("99");

    @Getter
    private final String code;

    ResultCode(String code){
        this.code = code;
    }

}