package com.tailor.admin.measurements.measurementFields;

//import com.tailor.admin.measurements.MeasurementField;
import com.tailor.admin.measurements.measurementTypes.MeasurementType;
import com.tailor.admin.measurements.measurementTypes.MeasurementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementFieldService {
    @Autowired
    private MeasurementFieldRepository measurementFieldRepository;
    @Autowired
    private MeasurementTypeRepository measurementTypeRepository;
    public ResponseEntity addMeasurementField(Long typeId, String fieldName) {
        Optional<MeasurementType> measurementTypeFromDB = measurementTypeRepository.findById(typeId);
        if (measurementTypeFromDB.isPresent()){
            MeasurementType measurementType = measurementTypeFromDB.get();
            MeasurementField measurementField = new MeasurementField();
            measurementField.setType(measurementType);
            measurementField.setFieldName(fieldName);
            MeasurementField savedMeasurementField = measurementFieldRepository.save(measurementField);
            return new ResponseEntity<>(savedMeasurementField, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("measurement type not found",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getAllMeasurementFieldsByMeasurementType(Long typeId) {
        Optional<MeasurementType> measurementTypeFromDB = measurementTypeRepository.findById(typeId);
        if (measurementTypeFromDB.isPresent()){
            MeasurementType measurementType = measurementTypeFromDB.get();
            List<MeasurementField> measurementFields = measurementType.getFields();
            return new ResponseEntity(measurementFields,HttpStatus.OK);
        }else {
            return new ResponseEntity("measurement type not found",HttpStatus.BAD_REQUEST);
        }
    }
}
