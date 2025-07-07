package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    private final CountryRepository repo;

    @Autowired
    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public List<Country> getAllCountries() {
        return repo.findAll();
    }
}
