package com.tailor.admin.measurements.measurements;

import com.tailor.admin.customers.Customer;
import com.tailor.admin.measurements.measurementTypes.MeasurementType;
import com.tailor.admin.measurements.measurementValues.MeasurementValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "measurements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MeasurementType type;

    @OneToMany(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeasurementValue> values;
}
