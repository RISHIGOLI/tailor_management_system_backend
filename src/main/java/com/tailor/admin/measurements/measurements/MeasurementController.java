package com.tailor.admin.measurements.measurements;

import com.tailor.admin.measurements.dtos.MeasurementRequest;
import com.tailor.admin.measurements.measurementValues.MeasurementValue;
import com.tailor.admin.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurement")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    public ResponseEntity<Response> addMeasurement(@RequestBody MeasurementRequest measurementRequest){
        System.out.println("customer id = "+ measurementRequest.getCustomerId()+ " type id = "+ measurementRequest.getTypeId());
        return measurementService.addMeasurement(measurementRequest);
    }

    @GetMapping
    public ResponseEntity<Response> getAllMeasurements(){
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Response> getMeasurementsByCustomerId(@PathVariable Long customerId){
        return measurementService.getMeasurementsByCustomerId(customerId);
    }
}
