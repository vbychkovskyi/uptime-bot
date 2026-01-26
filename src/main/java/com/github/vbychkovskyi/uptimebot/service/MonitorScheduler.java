package com.github.vbychkovskyi.uptimebot.service;

public interface MonitorScheduler {

  void startMonitor(Long id);

  void stopMonitor(Long id);
}
