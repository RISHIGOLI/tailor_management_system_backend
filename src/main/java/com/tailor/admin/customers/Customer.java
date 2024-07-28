package com.tailor.admin.customers;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tailor.admin.measurements.measurements.Measurement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @SequenceGenerator(
        name ="customer_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_sequence")
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerMobileNo;
    private String referredBy;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Measurement> measurements;
}
