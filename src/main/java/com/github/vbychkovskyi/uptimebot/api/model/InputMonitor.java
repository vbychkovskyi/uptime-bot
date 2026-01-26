package com.github.vbychkovskyi.uptimebot.api.model;

import java.time.Duration;

public record InputMonitor(String url, String name, Duration schedule) {

}
