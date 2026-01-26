package com.github.vbychkovskyi.uptimebot.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

  @Bean
  public JobDetail processOvertimePosOrderJobDetail() {
    return JobBuilder.newJob().ofType(MonitorJob.class)
      .requestRecovery()
      .storeDurably()
      .withIdentity(new JobKey("MONITOR_ID"))
      .withDescription("Process monitor job")
      .build();
  }
}
