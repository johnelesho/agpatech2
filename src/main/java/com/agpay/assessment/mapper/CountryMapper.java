package com.agpay.assessment.mapper;

import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;
import com.agpay.assessment.etc.ApiHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {



//   public static List<Country> MapAllToCountry(List<CountryDto> countryDtos) {
//      if (ApiHelper.isEmpty(countryDtos))
//         return null;
//
//      return countryDtos.stream().map(countryDto -> DtoToCountry(countryDto))
//              .collect(Collectors.toList());
//   }

//   public static List<CountryDto> MapAllToDto(List<Country> countries) {
//      if (ApiConstants.isEmpty(countries))
//         return null;
//
//      return countries.stream().map(country -> CountryToDto(country))
//              .collect(Collectors.toList());
//   }

   public static Country DtoToCountry(CountryDto countryDto, int id){
       Country country = new Country();
       country.setId(id);
       country.setName(countryDto.name());
       country.setDensityPKm2(countryDto.densityPKm2());
       country.setLandAreaInKm2(countryDto.landAreaInKm2());
       country.setPopulation(countryDto.population());

       return country;
    }

//    public static CountryDto CountryToDto(Country country){
//       CountryDto countryDto = new CountryDto();
//       country.setName(country.getName());
//
//       country.setDensityPKm2(country.getDensityPKm2());
//       country.setLandAreaInKm2(country.getLandAreaInKm2());
//
//       country.setPopulation(country.getPopulation());
//
//       return countryDto;
//    }
}
