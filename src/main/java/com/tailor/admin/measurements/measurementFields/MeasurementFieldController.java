package com.tailor.admin.measurements.measurementFields;

import com.tailor.admin.measurements.MeasurementField;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measurement-fields")
public class MeasurementFieldController {
    @Autowired
    private MeasurementFieldService measurementFieldService;

    @PostMapping
    public ResponseEntity<MeasurementField> addMeasurementField(@RequestParam Long typeId, @RequestParam String fieldName){
        return measurementFieldService.addMeasurementField(typeId,fieldName);
    }

    @GetMapping
    public ResponseEntity getAllMeasurementFieldsByMeasurementType(@RequestParam Long typeId){
        return measurementFieldService.getAllMeasurementFieldsByMeasurementType(typeId);
    }

}
