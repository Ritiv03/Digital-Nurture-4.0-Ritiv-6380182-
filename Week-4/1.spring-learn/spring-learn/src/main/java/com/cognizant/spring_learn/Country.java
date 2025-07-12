package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    static {
        System.out.println("STATIC BLOCK: Country class loaded.");
        LOGGER.debug("STATIC BLOCK: Logger initialized in Country.");
    }


    private String code;
    private String name;

    public Country() {
        System.out.println("INSIDE CONSTRUCTOR: Country()");
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode()");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode()");
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName()");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
