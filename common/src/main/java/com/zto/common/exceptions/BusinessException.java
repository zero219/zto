package com.zto.common.exceptions;

/**
 * 业务异常：自定义异常处理器，用于封装异常信息，对异常进行分类
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(){}

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
