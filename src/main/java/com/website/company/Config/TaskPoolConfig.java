package com.website.company.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @description: 
 *          ________
 *          ___  __/______________
 *          __  /_ ___  __ \  ___/
 *          _  __/ __  /_/ / /__
 *          /_/    _  .___/\___/
 *                 /_/
 * @author: www.fpcs.top
 *
 * @create: 2021-03-06 14:41
 */

@Configuration
@EnableAsync
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutro(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(100);
        taskExecutor.setMaxPoolSize(500);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("taskExecutor--");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }


}