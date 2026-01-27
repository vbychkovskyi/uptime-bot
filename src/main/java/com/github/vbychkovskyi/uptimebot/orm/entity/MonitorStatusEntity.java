package com.github.vbychkovskyi.uptimebot.orm.entity;

import java.time.Instant;

import com.github.vbychkovskyi.uptimebot.client.MonitorStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "monitor_status")
@Getter
@Setter
public class MonitorStatusEntity {

  @Id
  private Long id;

  private Long monitorId;

  @Enumerated(EnumType.STRING)
  private MonitorStatus status;

  private Instant lastCheckAt;

  private Instant lastStatusChangedAt;
}
