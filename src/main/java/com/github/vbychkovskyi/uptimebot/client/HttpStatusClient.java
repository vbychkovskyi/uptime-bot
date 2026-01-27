package com.github.vbychkovskyi.uptimebot.client;

import static java.net.URI.create;
import static java.time.Duration.ofSeconds;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.github.vbychkovskyi.uptimebot.api.model.Monitor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpStatusClient implements StatusClient {

  private final HttpClient client;

  @Override
  public MonitorStatus checkStatus(final Monitor monitor) {
    final var httpRequest = HttpRequest.newBuilder()
      .GET()
      .uri(create(monitor.url()))
      .timeout(ofSeconds(3))
      .build();

    try {
      final var send = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      if (send.statusCode() >= 200 && send.statusCode() < 300) {
        return MonitorStatus.UP;
      } else {
        return MonitorStatus.DOWN;
      }
    } catch (Exception ex) {
      log.warn("Error while checking status", ex);
      return MonitorStatus.DOWN;
    }
  }
}
