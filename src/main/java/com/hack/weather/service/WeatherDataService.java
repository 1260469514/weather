package com.hack.weather.service;

import com.hack.weather.dto.ResponseObject;
import com.hack.weather.vo.Weather;

public interface WeatherDataService {

    /**
     * 根据城市id获取天气预报数据
     * @param cityId
     * @return
     */
    ResponseObject getDataByCityId(Integer cityId);

    /**
     * 根据城市名称获取天气预报数据
     * @param cityName
     * @return
     */
    ResponseObject getDataByCityName(String cityName);
}
