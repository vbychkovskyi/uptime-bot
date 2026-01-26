package com.github.vbychkovskyi.uptimebot.api;

import java.util.List;

import com.github.vbychkovskyi.uptimebot.api.model.InputMonitor;
import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.service.MonitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Nullable
  @GetMapping("/monitor/{id}")
  public Monitor getMonitor(@PathVariable Long id) {

    return monitorService.getMonitor(id);
  }

  @Nullable
  @GetMapping("/monitors")
  public List<Monitor> getMonitors() {

    return monitorService.getMonitors();
  }

  @DeleteMapping("/monitor/{id}")
  public void deleteMonitor(@PathVariable Long id) {
    log.info("Delete monitor: {}", id);

    monitorService.deleteMonitor(id);
  }
}
