package com.cognizant.spring_learn;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START - main()");
		displayCountries(); // call your new method here
		LOGGER.info("END - main()");
	}

	public static void displayCountries() {
		LOGGER.info("START - displayCountries()");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries = context.getBean("countryList", List.class);

		for (Country c : countries) {
			LOGGER.debug("Country: {}", c); // This will trigger toString() and log each country
		}

		LOGGER.info("END - displayCountries()");
	}






}
