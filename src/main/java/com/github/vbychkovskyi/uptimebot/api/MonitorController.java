package com.github.vbychkovskyi.uptimebot.api;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MonitorController {

  private final MonitorService monitorService;

  @PostMapping("/monitor")
  public Monitor createMonitor(@RequestBody InputMonitor monitor) {
    log.info("Received monitor: {}", monitor);

    return monitorService.createMonitor(monitor);
  }
}
