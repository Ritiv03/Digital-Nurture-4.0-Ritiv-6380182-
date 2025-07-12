package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {
    private static List<Country> countries = new ArrayList<>();

    static {
        countries.add(new Country() {{ setCode("IN"); setName("India"); }});
        countries.add(new Country() {{ setCode("US"); setName("United States"); }});
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) {
        return countries.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    public Country addCountry(Country country) {
        countries.add(country);
        return country;
    }

    public void updateCountry(Country country) {
        Country existing = getCountry(country.getCode());
        existing.setName(country.getName());
    }

    public void deleteCountry(String code) {
        Country c = getCountry(code);
        countries.remove(c);
    }
}
