package com.github.vbychkovskyi.uptimebot.service.impl;

import static java.net.URI.create;
import static java.time.Duration.ofSeconds;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import com.github.vbychkovskyi.uptimebot.api.model.WebhookChannel;
import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;
import com.github.vbychkovskyi.uptimebot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebhookNotificationService implements NotificationService {

  private final HttpClient httpClient;

  @Override
  public void notify(final Monitor monitor, final MonitorStatus status) {
    switch (status) {
      case UP -> notify(monitor.upChannel());
      case DOWN -> notify(monitor.downChannel());
    }
  }

  @SneakyThrows
  private void notify(final WebhookChannel channel) {
    final var httpRequest = HttpRequest.newBuilder()
      .POST(HttpRequest.BodyPublishers.ofString(channel.body()))
      .header("Content-Type", "application/json")
      .uri(create(channel.url()))
      .build();

    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
  }
}
