package com.tailor.admin.measurements.measurementTypes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.tailor.admin.measurements.MeasurementField;
import com.tailor.admin.measurements.measurementFields.MeasurementField;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "measurement_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MeasurementField> fields;
}
