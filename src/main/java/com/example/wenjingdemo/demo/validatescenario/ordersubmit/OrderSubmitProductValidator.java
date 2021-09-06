package com.example.wenjingdemo.demo.validatescenario.ordersubmit;

import com.example.wenjingdemo.Validator.ValidatorContext;
import com.example.wenjingdemo.Validator.comment.Validator;
import com.example.wenjingdemo.Validator.constants.ValidateTypeEnum;
import com.example.wenjingdemo.Validator.exception.ValidateException;
import com.example.wenjingdemo.Validator.template.ValidatorTemplate;
import com.example.wenjingdemo.demo.businesscode.OrderSubmitDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/2 10:48 上午
 */
@Component
@Slf4j
@Validator(validateTypes = ValidateTypeEnum.ORDER_SUBMIT, validateOrder = 1)
public class OrderSubmitProductValidator extends ValidatorTemplate {
    @Override
    protected void validateInner() throws ValidateException {
        ValidatorContext validatorContext = ValidatorContext.getCurrentContext();
        OrderSubmitDTO orderSubmitDTO = validatorContext.getRequestDto();

        // 业务校验
        if (orderSubmitDTO.getProductNum() > 3){
            throw new ValidateException("商品库存不够");
        }

        orderSubmitDTO.setOrderName("testOrder");
        validatorContext.set("orderSubmitDTO", orderSubmitDTO);
    }
}
