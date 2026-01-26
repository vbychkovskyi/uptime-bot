package com.github.vbychkovskyi.uptimebot.orm.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {

}
