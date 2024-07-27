package com.tailor.admin.measurements.measurementFields;

import com.tailor.admin.measurements.MeasurementField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementFieldRepository extends JpaRepository<MeasurementField, Long> {
}
