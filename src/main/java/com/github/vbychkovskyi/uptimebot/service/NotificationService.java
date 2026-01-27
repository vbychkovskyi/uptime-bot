package com.github.vbychkovskyi.uptimebot.service;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;

public interface NotificationService {

  void notify(Monitor monitor, MonitorStatus status);
}
