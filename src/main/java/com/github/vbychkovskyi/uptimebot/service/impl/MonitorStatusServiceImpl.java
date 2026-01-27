package com.github.vbychkovskyi.uptimebot.service.impl;

import java.time.Clock;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;
import com.github.vbychkovskyi.uptimebot.orm.entity.MonitorStatusRepository;
import com.github.vbychkovskyi.uptimebot.service.MonitorStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MonitorStatusServiceImpl implements MonitorStatusService {

  private final Clock clock;
  private final MonitorStatusRepository monitorStatusRepository;

  @Override
  @Transactional
  public boolean update(final Monitor monitor, final MonitorStatus status) {
    final var entity = monitorStatusRepository.findById(monitor.id())
      .orElseThrow();

    final var statusChanged = entity.getStatus() == status;

    var statusChangedAt = statusChanged ? clock.instant() : entity.getLastStatusChangedAt();

    entity.setLastCheckAt(clock.instant());
    entity.setStatus(status);
    entity.setLastStatusChangedAt(statusChangedAt);

    return statusChanged;
  }
}
