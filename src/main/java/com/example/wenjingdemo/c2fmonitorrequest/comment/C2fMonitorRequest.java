package com.example.wenjingdemo.c2fmonitorrequest.comment;

import java.lang.annotation.*;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: 拦截请求注解
 * @date 2021/9/11 8:54 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface C2fMonitorRequest {
}
