package com.github.vbychkovskyi.uptimebot.api.model;

import java.time.Duration;

public record Monitor(Long id, String name, String url, Duration schedule, WebhookChannel upChannel,
                      WebhookChannel downChannel) {

}
