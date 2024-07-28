package com.tailor.admin.measurements.measurementValues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementValueRepository extends JpaRepository<MeasurementValue, Long> {
}
