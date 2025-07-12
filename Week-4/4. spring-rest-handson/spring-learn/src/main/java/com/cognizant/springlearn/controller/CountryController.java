package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping
    public void updateCountry(@RequestBody @Valid Country country) {
        countryService.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
    }
}
