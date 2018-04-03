package com.hack.weather.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherSyncJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(WeatherSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("redis data sync");
    }
}
