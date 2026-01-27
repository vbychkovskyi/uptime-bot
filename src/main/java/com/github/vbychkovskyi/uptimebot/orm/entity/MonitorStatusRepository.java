package com.github.vbychkovskyi.uptimebot.orm.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorStatusRepository extends JpaRepository<MonitorStatusEntity, Long> {

  Optional<MonitorStatusEntity> findByMonitorId(Long monitorId);
}
