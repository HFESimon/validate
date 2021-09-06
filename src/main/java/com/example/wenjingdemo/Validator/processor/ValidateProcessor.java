package com.example.wenjingdemo.Validator.processor;

import com.example.wenjingdemo.Validator.ValidatorContext;
import com.example.wenjingdemo.Validator.comment.Validator;
import com.example.wenjingdemo.Validator.template.ValidatorTemplate;
import com.example.wenjingdemo.Validator.template.ValidatorTemplateProxy;
import com.example.wenjingdemo.Validator.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: 校验执行器
 * @date 2021/9/1 7:48 下午
 */
@Slf4j
@Component
public class ValidateProcessor {

    public void validate(String validateType){
        Optional.ofNullable(validateType).orElseThrow(() -> new IllegalArgumentException("校验类型不能为空"));

        long start = System.currentTimeMillis();
        log.info("======>开始进行业务校验, 校验场景:{}, 校验线程上下文:{}", validateType, ValidatorContext.getCurrentContext().toString());

        List<ValidatorTemplateProxy> validatorTemplateProxies = getValidatorList(validateType);
        if (CollectionUtils.isEmpty(validatorTemplateProxies)){
            log.info("待校验任务列表为空");
            return;
        }

        for (ValidatorTemplateProxy validatorTemplateProxy : validatorTemplateProxies){
            log.info("正在执行 {} 校验", validatorTemplateProxy.getValidatorTemplate().getClass().getSimpleName());
            validatorTemplateProxy.validate();
        }
        log.info("校验结束, 校验业务场景{}, 校验线程上下文{}, 校验耗时 {} ms", validateType, ValidatorContext.getCurrentContext().toString(), (System.currentTimeMillis() - start));
    }


    private List<ValidatorTemplateProxy> getValidatorList(String validateType){
        List<ValidatorTemplateProxy> validatorTemplateProxies = new LinkedList<>();
        Map<String, Object> map = SpringUtil.getApplicationContext().getBeansWithAnnotation(Validator.class);

        for (Map.Entry<String, Object> item : map.entrySet()){
            Annotation annotation = item.getValue().getClass().getAnnotation(Validator.class);
            String[] validateTypes = ((Validator) annotation).validateTypes();
            int validateOrder = ((Validator) annotation).validateOrder();
            if (item.getValue() instanceof ValidatorTemplate){
                if (Arrays.asList(validateTypes).contains(validateType)){
                    validatorTemplateProxies.add(new ValidatorTemplateProxy((ValidatorTemplate) item.getValue(), validateType, validateOrder));
                }
            } else {
                log.info("{} 类没有使用@Validator注解", item.getKey());
            }
        }
        Collections.sort(validatorTemplateProxies);
        return validatorTemplateProxies;
    }

}
