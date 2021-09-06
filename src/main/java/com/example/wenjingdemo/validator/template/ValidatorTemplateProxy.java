package com.example.wenjingdemo.validator.template;

import com.example.wenjingdemo.validator.exception.ValidateException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: ValidatorTemplate类的代理类，实现了Comparable排序接口，便于校验器按照validateOrder属性排序，并且将校验器中的注解转化为代理类中的两个属性字段，方便执行过程中的统一日志打印。
 * @date 2021/9/1 3:23 上午
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidatorTemplateProxy extends ValidatorTemplate implements Comparable<ValidatorTemplateProxy> {


    private ValidatorTemplate validatorTemplate;

    private String validateType;

    private int validateOrder;

    @Override
    protected void validateInner() throws ValidateException {
        validatorTemplate.validateInner();
    }

    @Override
    public int compareTo(ValidatorTemplateProxy o) {
        return Integer.compare(this.getValidateOrder(), o.getValidateOrder());
    }
}
