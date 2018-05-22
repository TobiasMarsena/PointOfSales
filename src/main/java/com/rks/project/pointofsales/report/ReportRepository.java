package com.rks.project.pointofsales.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 22/05/2018.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
