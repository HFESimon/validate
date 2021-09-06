package com.example.wenjingdemo.demo.businesscode;

import lombok.Data;

/**
 * @author wenjing.zsm
 * @version 1.0
 * @title:
 * @description:
 * @date 2021/9/2 10:57 上午
 */
@Data
public class OrderSubmitDTO {

    private String orderName;

    private String productName;

    private Long productId;

    private Integer productNum;

    private String customerName;
}
