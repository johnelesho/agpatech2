package com.agpay.assessment.services.implementations;

import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;
import com.agpay.assessment.repositories.contracts.ICountryRepository;
import com.agpay.assessment.services.contracts.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries(String search, int page, int size) {

        return countryRepository.findAllByName(search, page, size);

    }
    @Override
    public Country createCountry(CountryDto dto) {
        return countryRepository.save(dto);
    }
    @Override
    public List<Country> createCountries(List<CountryDto> request) {
        return countryRepository.saveAll(request);
    }

    @Override
    public List<Country> getCountriesByName(String name) {
        return countryRepository.findAllByName(name);
    }

    @Override
    public Country getCountryById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }


}
