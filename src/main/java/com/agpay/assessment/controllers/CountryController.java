package com.agpay.assessment.controllers;

import com.agpay.assessment.dtos.ApiResponse;
import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;
import com.agpay.assessment.etc.ApiHelper;
import com.agpay.assessment.services.contracts.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private ICountryService countryService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getAllCountries(@RequestParam(value = "search", required = false) String search,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size){
        List<Country> responseData= new ArrayList<>();
        try {
           responseData = countryService.getAllCountries(search, page, size);
                return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.OK, "Success"), HttpStatus.OK);

        }
        catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getCountryById(@PathVariable("id") int id){
        Country responseData = null;
        try{
            responseData = countryService.getCountryById(id);
            return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.OK, "Success"), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addNewCountry(@RequestBody CountryDto request){
        Country responseData = null;
        try{
            responseData = countryService.createCountry(request);
            return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.CREATED, "Success"), HttpStatus.CREATED);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(responseData, HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
