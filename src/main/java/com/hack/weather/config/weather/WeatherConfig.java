package com.hack.weather.config.weather;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "weather.api",ignoreUnknownFields = false)
@PropertySource("classpath:weather.properties")
public class WeatherConfig {

    private String url;
}
