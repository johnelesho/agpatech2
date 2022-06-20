package com.agpay.assessment.entities;

import com.agpay.assessment.dtos.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
    private int    id;
    private String name;
    private String population;
    private String landAreaInKm2;
    private String  densityPKm2;

public Object get(String key){
    switch (key){
        case "id":
            return getId();
        case "name":
            return getName();
        case "population":
            return getPopulation();
        case "landAreaInKm2":
            return getLandAreaInKm2();
        case "densityPKm2":
            return getDensityPKm2();
//        case "region":
//            return getRegion();
//        case "capital":
//            return getCapital();
        default:
            return null;
    }
    }
}
