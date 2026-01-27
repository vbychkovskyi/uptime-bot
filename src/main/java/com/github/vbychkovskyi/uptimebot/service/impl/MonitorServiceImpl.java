package com.github.vbychkovskyi.uptimebot.service.impl;

import java.util.List;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.orm.entity.MonitorEntity;
import com.github.vbychkovskyi.uptimebot.orm.entity.MonitorRepository;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
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
    monitorEntity.setUpChannel(monitor.upChannel());
    monitorEntity.setDownChannel(monitor.downChannel());
    final var save = monitorRepository.save(monitorEntity);
    return mapMonitor(save);
  }

  @Override
  @Nullable
  public Monitor getMonitor(final Long id) {
    return monitorRepository.findById(id)
      .map(this::mapMonitor)
      .orElseThrow();
  }

  private Monitor mapMonitor(final MonitorEntity v) {
    return new Monitor(
      v.getId(),
      v.getName(),
      v.getUrl(),
      v.getSchedule(),
      v.getUpChannel(),
      v.getDownChannel()
    );
  }

  @Override
  public List<Monitor> getMonitors() {
    return monitorRepository.findAll()
      .stream()
      .map(this::mapMonitor)
      .toList();
  }

  @Override
  @Transactional
  public void deleteMonitor(final Long monitorId) {
    monitorRepository.deleteById(monitorId);
  }
}
