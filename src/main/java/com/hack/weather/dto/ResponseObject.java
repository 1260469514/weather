package com.hack.weather.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResponseObject implements Serializable{
//    数据
    private Object data;
//    状态码
    private String status;
//    状态信息
    private String desc;

}
