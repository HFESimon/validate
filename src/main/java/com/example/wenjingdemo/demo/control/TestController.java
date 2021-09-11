package com.example.wenjingdemo.demo.control;

import com.example.wenjingdemo.c2fmonitorrequest.comment.C2fMonitorRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/11 9:15 上午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @C2fMonitorRequest
    @GetMapping("/haveMonitor")
    public String test1(){
        return "method be added @C2fMonitorRequest";
    }

    @GetMapping("/noMonitor")
    public String test2(){
        return "method not add @C2fMonitorRequest";
    }
}
