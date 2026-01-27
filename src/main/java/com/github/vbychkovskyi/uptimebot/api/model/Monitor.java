package com.github.vbychkovskyi.uptimebot.api.model;

import java.time.Duration;

public record Monitor(Long id, String url, String name, Duration schedule, WebhookChannel upChannel,
                      WebhookChannel downChannel) {

}
