package com.example.wenjingdemo.validator.template;

import com.example.wenjingdemo.validator.constants.ValidateResultEnum;
import com.example.wenjingdemo.validator.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/1 2:52 上午
 */
@Slf4j
@Component
public abstract class ValidatorTemplate {

    /**
     * 校验
     */
    public void validate() {
        try {
            validateInner();
        } catch (ValidateException e) {
            log.error("业务校验失败", e);
            throw e;
        } catch (Exception e) {
            log.error("业务校验异常", e);
            throw new ValidateException(ValidateResultEnum.VALIDATE_ERROR);
        }
    }

    /**
     * 校验方法，由子类实现
     *
     * @throws ValidateException
     */
    protected abstract void validateInner() throws ValidateException;
}
