package com.caict3in.server.demo.exception;

import com.caict3in.server.demo.common.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常类
 * @author daisx
 */
@Getter
@Setter
public class CustomException extends RuntimeException{

    protected String code;

    protected String message;

    public CustomException() {
        this.code= ErrorCode.B0001.getCode();
        this.message = ErrorCode.B0001.getMessage();
    }

    public CustomException(String msg) {
        this.code= ErrorCode.B0001.getCode();
        this.message = msg;
    }

    public CustomException(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

}
