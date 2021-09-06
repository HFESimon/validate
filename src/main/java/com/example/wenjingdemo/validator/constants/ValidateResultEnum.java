package com.example.wenjingdemo.validator.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/1 2:55 上午
 */
@Getter
@AllArgsConstructor
public enum ValidateResultEnum {

    /**
     * 业务校验结果
     */
    VALIDATE_SUCCESS(200, "业务校验成功"),
    VALIDATE_ERROR(4000, "业务校验异常");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    public static ValidateResultEnum query(String code){
        Optional<ValidateResultEnum> first = Arrays.stream(ValidateResultEnum.values()).filter(c -> Objects.equals(code, c.getCode())).findFirst();
        return first.orElse(null);
    }

}
