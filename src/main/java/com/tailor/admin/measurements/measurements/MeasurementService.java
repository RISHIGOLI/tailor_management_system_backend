package com.tailor.admin.measurements.measurements;

import com.tailor.admin.customers.Customer;
import com.tailor.admin.customers.CustomerRepository;
import com.tailor.admin.measurements.dtos.MeasurementFieldDTO;
import com.tailor.admin.measurements.dtos.MeasurementRequest;
import com.tailor.admin.measurements.measurementTypes.MeasurementType;
import com.tailor.admin.measurements.measurementTypes.MeasurementTypeRepository;
import com.tailor.admin.measurements.measurementValues.MeasurementValue;
import com.tailor.admin.measurements.measurementValues.MeasurementValueRepository;
import com.tailor.admin.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MeasurementTypeRepository measurementTypeRepository;
    @Autowired
    private MeasurementValueRepository measurementValueRepository;

    public ResponseEntity<Response> addMeasurement(MeasurementRequest measurementRequest) {
        System.out.println("customer id = "+ measurementRequest.getCustomerId()+ " type id = "+ measurementRequest.getTypeId());
        Measurement measurement = new Measurement();
        // setting customer
        Optional<Customer> customer = customerRepository.findById(measurementRequest.getCustomerId());
        if (!customer.isPresent()){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "customer not found"),HttpStatus.BAD_REQUEST);
        }else {
            measurement.setCustomer(customer.get());
        }

        // setting measurement type
        Optional<MeasurementType> measurementType = measurementTypeRepository.findById(measurementRequest.getTypeId());
        if (!measurementType.isPresent()){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "measurement type not found"), HttpStatus.BAD_REQUEST);
        }
        measurement.setType(measurementType.get());
        List<MeasurementValue> measurementValues = new ArrayList<>();

        for (MeasurementFieldDTO fieldDTO : measurementRequest.getValues()){
            MeasurementValue measurementValue = new MeasurementValue();
            measurementValue.setFieldName(fieldDTO.getFieldName());
            measurementValue.setFieldValue(fieldDTO.getFieldValue());
            measurementValue.setMeasurement(measurement);
            measurementValues.add(measurementValue);
        }

        measurement.setValues(measurementValues);

        Measurement savedMeasurement = measurementRepository.save(measurement);
        measurementValueRepository.saveAll(measurementValues);
        return new ResponseEntity<>(new Response(true, HttpStatus.CREATED.value(), "measurement added successfully", Collections.singletonList(savedMeasurement)),HttpStatus.CREATED);
    }


    public ResponseEntity<Response> getAllMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Query successful",measurements),HttpStatus.OK);
    }

    public ResponseEntity<Response> getMeasurementsByCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "customer not found"),HttpStatus.BAD_REQUEST);
        }
        List<Measurement> measurements = measurementRepository.findByCustomerCustomerId(customer.get().getCustomerId());
        return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Query successful",measurements), HttpStatus.OK);
    }
}
