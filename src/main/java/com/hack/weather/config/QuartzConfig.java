package com.hack.weather.config;

import com.hack.weather.job.WeatherSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherSyncJob.class).withIdentity("weatherDataSyncJobDetail").storeDurably().build();
    }

    @Bean public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder scheduler = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(scheduler).build();
    }
}
