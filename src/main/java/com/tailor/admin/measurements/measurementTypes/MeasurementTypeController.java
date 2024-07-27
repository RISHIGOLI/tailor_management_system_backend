package com.tailor.admin.measurements.measurementTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measurement-types")
public class MeasurementTypeController {

    @Autowired
    private MeasurementTypeService measurementTypeService;

    @PostMapping
    public ResponseEntity<MeasurementType> addMeasurementType(@RequestBody MeasurementType measurementType){
        return measurementTypeService.addMeasurementType(measurementType);
    }

    @GetMapping
    public ResponseEntity getMeasurementTypeByTypeId(@RequestParam Long typeId){
        return measurementTypeService.getMeasurementTypeByTypeId(typeId);
    }

    @GetMapping("/{typeName}")
    public ResponseEntity getMeasurementTypeByTypeName(@PathVariable String typeName){
        return measurementTypeService.getMeasurementTypeByTypeName(typeName);
    }
}
