package com.github.vbychkovskyi.uptimebot.service;

import java.net.http.HttpClient;
import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public HttpClient httpClient() {
    return HttpClient.newBuilder()
      .connectTimeout(java.time.Duration.ofSeconds(3))
      .build();
  }

  @Bean
  public Clock clock() {
    return Clock.systemUTC();
  }
}
