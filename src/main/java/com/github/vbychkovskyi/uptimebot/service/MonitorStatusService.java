package com.github.vbychkovskyi.uptimebot.service;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;

public interface MonitorStatusService {

  boolean update(Monitor monitor, MonitorStatus status);
}
