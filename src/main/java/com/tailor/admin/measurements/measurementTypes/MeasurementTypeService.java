package com.tailor.admin.measurements.measurementTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementTypeService {
    @Autowired
    private MeasurementTypeRepository measurementTypeRepository;
    public ResponseEntity<MeasurementType> addMeasurementType(MeasurementType measurementType) {
        MeasurementType type = measurementTypeRepository.save(measurementType);
        return new ResponseEntity(type, HttpStatus.CREATED);
    }

    public ResponseEntity getMeasurementTypeByTypeId(Long typeId) {
        Optional<MeasurementType> measurementType =  measurementTypeRepository.findById(typeId);
        if (measurementType.isPresent()){
            MeasurementType measurementTypeFromDB = measurementType.get();
            return new ResponseEntity(measurementTypeFromDB,HttpStatus.OK);
        }else{
            return new ResponseEntity("measurement type not found",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getMeasurementTypeByTypeName(String typeName) {
        MeasurementType measurementType =  measurementTypeRepository.findByTypeName(typeName);
        if (measurementType != null){
            return new ResponseEntity(measurementType,HttpStatus.OK);
        }else{
            return new ResponseEntity("measurement type not found",HttpStatus.BAD_REQUEST);
        }
    }
}
