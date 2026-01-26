package com.github.vbychkovskyi.uptimebot.orm.entity;

import java.time.Duration;

import io.hypersistence.utils.hibernate.type.interval.PostgreSQLIntervalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monitor_id_sequence")
  @SequenceGenerator(
    name = "monitor_id_sequence",
    sequenceName = "monitor_id_sequence",
    allocationSize = 1
  )
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
