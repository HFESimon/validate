package com.example.wenjingdemo.c2fmonitorrequest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description: aop切面类
 * @date 2021/9/11 8:57 上午
 */
@Aspect
@Component
@Slf4j
public class RequestAspect {


    @Before(value = "@annotation(com.example.wenjingdemo.c2fmonitorrequest.comment.C2fMonitorRequest)")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes
                = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest servletRequest = servletRequestAttributes.getRequest();


        //URL：根据请求对象拿到访问的地址
        log.info("url=" + servletRequest.getRequestURL());
        //获取请求的方法，是Get还是Post请求
        log.info("method=" + servletRequest.getMethod());
        //ip：获取到访问
        log.info("ip=" + servletRequest.getRemoteAddr());
        //获取被拦截的类名和方法名
        log.info("class=" + joinPoint.getSignature().getDeclaringTypeName() +
                "and method name=" + joinPoint.getSignature().getName());
        //参数
        log.info("参数=" + joinPoint.getArgs().toString());
    }
}
