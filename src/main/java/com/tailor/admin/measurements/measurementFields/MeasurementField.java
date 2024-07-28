package com.tailor.admin.measurements.measurementFields;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tailor.admin.measurements.measurementTypes.MeasurementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "measurement_fields")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    @JsonBackReference
    private MeasurementType type;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

}