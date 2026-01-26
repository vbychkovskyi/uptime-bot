package com.github.vbychkovskyi.uptimebot.orm.entity;

import java.time.Duration;

import io.hypersistence.utils.hibernate.type.interval.PostgreSQLIntervalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "monitor")
@Getter
@Setter
public class MonitorEntity {

  @Id
  private Long id;

  private String name;

  private String url;

  @Type(PostgreSQLIntervalType.class)
  @Column(
    name = "schedule",
    columnDefinition = "interval"
  )
  private Duration schedule;
}
