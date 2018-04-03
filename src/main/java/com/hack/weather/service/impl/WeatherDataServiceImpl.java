package com.hack.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hack.weather.config.weather.WeatherConfig;
import com.hack.weather.dto.ResponseObject;
import com.hack.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@EnableConfigurationProperties(WeatherConfig.class)
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WeatherConfig weatherConfig;


    @Override
    public ResponseObject getDataByCityId(Integer cityId) {
        String url = weatherConfig.getUrl() + "cityKey=" + cityId;
        ResponseObject weather = getWeatherResponseObject(url);
        return weather;
    }

    private ResponseObject getWeatherResponseObject(String url) {
        String body = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(url)) {
            logger.info("Redis has data");
            body = ops.get(url);
        } else {
            logger.info("Redis don't has data");
            ResponseEntity<String> rep = restTemplate.getForEntity(url, String.class);
            if (rep.getStatusCodeValue() == 200) {
                body = rep.getBody();
                ops.set(url, body, TIME_OUT, TimeUnit.SECONDS);
            }
        }
        ResponseObject weather = null;
        try {
            weather = mapper.readValue(body, ResponseObject.class);
        } catch (IOException e) {
            logger.error("Error!",e);
            e.printStackTrace();
        }
        return weather;
    }

    @Override
    public ResponseObject getDataByCityName(String cityName) {
        String url = weatherConfig.getUrl() + "city=" + cityName;
        ResponseObject weather = this.getWeatherResponseObject(url);
        return weather;
    }
}
