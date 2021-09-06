package com.example.wenjingdemo.validator.exception;

import com.example.wenjingdemo.validator.constants.ValidateResultEnum;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/1 3:17 上午
 */
public class ValidateException extends RuntimeException {

    /**
     * 异常码
     */
    private Integer code;

    public ValidateException() {

    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(ValidateResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
