package com.hack.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 未来的天气预报
 */
@Getter
@Setter
@ToString
public class Forecast implements Serializable{
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
