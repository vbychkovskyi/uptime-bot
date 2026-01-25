package com.github.vbychkovskyi.uptimebot.api;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MonitorController {

  @PostMapping("/monitor")
  public void createMonitor(@RequestBody Monitor monitor) {
    log.info("Received monitor: {}", monitor);
  }
}
