package com.github.vbychkovskyi.uptimebot.service.impl;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.orm.entity.MonitorEntity;
import com.github.vbychkovskyi.uptimebot.orm.entity.MonitorRepository;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {

  private final MonitorRepository monitorRepository;

  @Override
  @Transactional
  public Monitor createMonitor(final InputMonitor monitor) {
    final var monitorEntity = new MonitorEntity();
    monitorEntity.setName(monitor.name());
    monitorEntity.setSchedule(monitor.schedule());
    monitorEntity.setUrl(monitor.url());
    final var save = monitorRepository.save(monitorEntity);
    return new Monitor(save.getId(), monitor.name(), monitor.url(), monitor.schedule());
  }
}
