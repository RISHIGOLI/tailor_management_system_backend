package com.tailor.admin.measurements.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class MeasurementRequest {
    private Long customerId;
    private Long typeId;
//    private String measurementDesc;
    private List<MeasurementFieldDTO> values;
}
