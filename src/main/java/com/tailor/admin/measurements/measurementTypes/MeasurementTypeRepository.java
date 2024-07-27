package com.tailor.admin.measurements.measurementTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Long> {
    MeasurementType findByTypeName(String typeName);
}
