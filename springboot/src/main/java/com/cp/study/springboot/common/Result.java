package com.cp.study.springboot.common;

import com.cp.study.springboot.common.CommonConstants.ResultCode;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    @Builder.Default
    private ResultCode resultCode = ResultCode.FAIL;
    private String resultMessage;
}

