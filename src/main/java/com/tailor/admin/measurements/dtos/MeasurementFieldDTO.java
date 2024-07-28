package com.tailor.admin.measurements.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MeasurementFieldDTO {
    private String fieldName;
    private String fieldValue;
}
