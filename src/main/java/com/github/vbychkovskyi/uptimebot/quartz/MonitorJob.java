package com.github.vbychkovskyi.uptimebot.quartz;

import com.github.vbychkovskyi.uptimebot.client.StatusClient;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import com.github.vbychkovskyi.uptimebot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MonitorJob extends QuartzJobBean {

  public static final String MONITOR_ID = "MONITOR_ID";

  private final MonitorService monitorService;
  private final StatusClient statusClient;
  private final NotificationService notificationService;

  @Override
  protected void executeInternal(final JobExecutionContext context) {
    log.info("Monitor job is executed");

    final var monitor = monitorService.getMonitor(context.getMergedJobDataMap().getLong(MONITOR_ID));

    final var status = statusClient.checkStatus(monitor);

    notificationService.notify(monitor, status);
  }
}
