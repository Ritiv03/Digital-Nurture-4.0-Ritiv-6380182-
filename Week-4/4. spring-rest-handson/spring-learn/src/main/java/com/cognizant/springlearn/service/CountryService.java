package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public Country getCountry(String code) {
        return countryDao.getCountry(code);
    }

    public Country addCountry(Country country) {
        return countryDao.addCountry(country);
    }

    public Country updateCountry(Country country) {
        countryDao.updateCountry(country);
        return country;
    }

    public void deleteCountry(String code) {
        countryDao.deleteCountry(code);
    }
}
