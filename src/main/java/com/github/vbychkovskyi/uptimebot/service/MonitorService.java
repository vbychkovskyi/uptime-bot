package com.github.vbychkovskyi.uptimebot.service;

import java.util.List;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import org.jspecify.annotations.Nullable;

public interface MonitorService {

  @Nullable
  Monitor getMonitor(Long id);

  List<Monitor> getMonitors();

  Monitor createMonitor(InputMonitor monitor);

  void deleteMonitor(Long id);
}
