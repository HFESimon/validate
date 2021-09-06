package com.example.wenjingdemo;

import com.example.wenjingdemo.Validator.ValidatorContext;
import com.example.wenjingdemo.Validator.constants.ValidateTypeEnum;
import com.example.wenjingdemo.Validator.processor.ValidateProcessor;
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
        validateProcessor.validate(ValidateTypeEnum.LOGIN);

        System.out.println(validatorContext.getObj("orderSubmitDTO").toString());
    }

}
