package com.github.vbychkovskyi.uptimebot.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MonitorJob extends QuartzJobBean {

  @Override
  protected void executeInternal(final JobExecutionContext context) {
    log.info("Monitor job is executed");
  }
}
