package com.github.vbychkovskyi.uptimebot.service;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;

public interface MonitorService {

  Monitor createMonitor(InputMonitor monitor);
}
