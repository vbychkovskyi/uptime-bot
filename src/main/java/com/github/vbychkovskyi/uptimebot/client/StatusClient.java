package com.github.vbychkovskyi.uptimebot.client;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;

public interface StatusClient {

  MonitorStatus checkStatus(Monitor monitor);
}
