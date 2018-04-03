package com.hack.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 当天的天气预报
 */
@Getter
@Setter
@ToString
public class Weather implements Serializable {

    private Yesterday yesterday;
    private String city;
    private Integer api;
    private List<Forecast> forecast;
    private String ganmao;
    private Integer wendu;

}
