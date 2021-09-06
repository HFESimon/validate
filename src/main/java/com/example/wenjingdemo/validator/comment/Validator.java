package com.example.wenjingdemo.validator.comment;

import java.lang.annotation.*;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: Validator校验注解，在校验器的类上加上该注解则表明为业务校验器，validateTypes表示业务类型，同一个校验器可以指定多个业务类型，多个业务类型可以复用同一个校验器，validateOrder表示执行顺序，数值越小越先被执行。
 * @date 2021/8/31 4:38 下午
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {

    /**
     * 业务类型，同一个校验器可以指定多个业务类型
     * @return
     */
    String[] validateTypes();

    /**
     * 执行顺序，数字越小越先执行
     * @return
     */
    int validateOrder();

}
