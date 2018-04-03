package com.hack.weather.controller;

import com.hack.weather.dto.ResponseObject;
import com.hack.weather.service.WeatherDataService;
import com.hack.weather.vo.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Resource
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public ResponseObject getWeatherInfoByCityId(@PathVariable("cityId") Integer cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("cityName/{cityName}")
    public ResponseObject getWeatherInfoByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }


}
