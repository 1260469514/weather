package com.hack.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;

@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate(){
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return new RestTemplateBuilder().additionalMessageConverters(m).build();
    }
}

