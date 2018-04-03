package com.hack.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 昨天的天气预报
 */
@Getter
@Setter
@ToString
public class Yesterday implements Serializable{
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
