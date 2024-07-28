package com.tailor.admin.measurements.measurementValues;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tailor.admin.measurements.measurements.Measurement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "measurement_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "measurement_id", nullable = false)
    @JsonBackReference
    private Measurement measurement;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "field_value", nullable = false)
    private String fieldValue;
}
