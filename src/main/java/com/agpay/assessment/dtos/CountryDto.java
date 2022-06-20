package com.agpay.assessment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

public record CountryDto(
        String name,
        String population,
        String landAreaInKm2,
        String  densityPKm2
)        {
    public CountryDto{
                Objects.requireNonNull(name);
                Objects.requireNonNull(population);
    }

}
