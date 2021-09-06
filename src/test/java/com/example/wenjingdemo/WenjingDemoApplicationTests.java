package com.example.wenjingdemo;

import com.example.wenjingdemo.validator.ValidatorContext;
import com.example.wenjingdemo.validator.constants.ValidateTypeEnum;
import com.example.wenjingdemo.validator.processor.ValidateProcessor;
import com.example.wenjingdemo.demo.businesscode.OrderSubmitDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WenjingDemoApplicationTests {

    @Test
    void contextLoads() {

        OrderSubmitDTO orderSubmitDTO = new OrderSubmitDTO();
        orderSubmitDTO.setProductNum(2);
        orderSubmitDTO.setCustomerName("wenjing");

        ValidatorContext validatorContext = ValidatorContext.getCurrentContext();
        validatorContext.setRequestDto(orderSubmitDTO);
        // 声明校验执行器
        ValidateProcessor validateProcessor = new ValidateProcessor();
        validateProcessor.validate(ValidateTypeEnum.ORDER_SUBMIT);

        System.out.println(validatorContext.getObj("orderSubmitDTO").toString());
    }

}
