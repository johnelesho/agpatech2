package com.agpay.assessment.repositories.contracts;

import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;

import com.agpay.assessment.etc.CountryInfoEnum;

import java.util.List;

public interface ICountryRepository {
    List<Country> findAll();
    List<Country> findAllByName(String search, int page, int size);
    List<Country> findAllBy(String key);
    Country save(CountryDto dto);

    Country findById(int id);
    Country findByName(String name);
    Country findBy(CountryInfoEnum key, Object value);


    Country updateById(int id, CountryDto dto) throws IllegalAccessException;

    Country updateByName(String name, CountryDto dto) throws IllegalAccessException;

    List<Country> saveAll(List<CountryDto> request);


    List<Country> findAllByName(String name);
}
