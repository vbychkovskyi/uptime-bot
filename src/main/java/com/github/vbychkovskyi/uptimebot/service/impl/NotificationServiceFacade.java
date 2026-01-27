package com.github.vbychkovskyi.uptimebot.service.impl;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;
import com.github.vbychkovskyi.uptimebot.service.MonitorStatusService;
import com.github.vbychkovskyi.uptimebot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
@RequiredArgsConstructor
public class NotificationServiceFacade implements NotificationService {

  private final MonitorStatusService monitorStatusService;
  private final NotificationService notificationService;

  @Override
  public void notify(final Monitor monitor, final MonitorStatus status) {

    if (monitorStatusService.update(monitor, status)) {
      log.info("Monitor status changed: {} status: {}", monitor.name(), status);

      notificationService.notify(monitor, status);
    } else {
      log.info("Monitor status not changed: {} status: {}", monitor.name(), status);
    }
  }
}
