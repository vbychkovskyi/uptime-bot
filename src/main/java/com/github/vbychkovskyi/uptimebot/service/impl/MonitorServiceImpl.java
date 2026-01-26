package com.github.vbychkovskyi.uptimebot.service.impl;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService {

  @Override
  public Monitor createMonitor(final InputMonitor monitor) {
    return null;
  }
}
