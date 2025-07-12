package com.cognizant.SpringREST.controller;

import com.cognizant.SpringREST.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class CountryController {

    public CountryController() {
        System.out.println("INSIDE CONSTRUCTOR: CountryController");
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country");
        return country;
    }
}
