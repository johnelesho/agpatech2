package com.agpay.assessment.services.contracts;

import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries(String search, int page, int size);

    Country createCountry(CountryDto request);

    Country getCountryById(int id);

    Country getCountryByName(String name);

    List<Country> createCountries(List<CountryDto> request);

    List<Country> getCountriesByName(String name);
}
