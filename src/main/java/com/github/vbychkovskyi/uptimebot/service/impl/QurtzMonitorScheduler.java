package com.github.vbychkovskyi.uptimebot.service.impl;

import static java.util.Date.from;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.sql.Date;
import java.time.Instant;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.service.MonitorScheduler;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QurtzMonitorScheduler implements MonitorScheduler {

  private static final String MONITOR_ID = "monitorId";

  private final Scheduler scheduler;
  private final MonitorService monitorService;

  @Override
  @SneakyThrows
  public void startMonitor(final Long id) {
    final var monitor = monitorService.getMonitor(id);

    final var trigger = newTrigger()
      .forJob(new JobKey("MONITOR_ID"))
      .withIdentity(TriggerKey.triggerKey("Monitor: " + id))
      .usingJobData(MONITOR_ID, id)
      .startAt(Instant.now())
      .withSchedule(simpleSchedule()
        .withIntervalInSeconds((int) monitor.schedule().getSeconds())
        .repeatForever()
      )
      .build();

    scheduler.scheduleJob(trigger);
  }

  @Override
  @SneakyThrows
  public void stopMonitor(final Long id) {
    scheduler.unscheduleJob(TriggerKey.triggerKey("Monitor: " + id));
  }
}
