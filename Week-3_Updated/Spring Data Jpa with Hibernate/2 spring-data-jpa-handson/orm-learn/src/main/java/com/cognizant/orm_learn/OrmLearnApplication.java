package com.cognizant.orm_learn;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryRepository countryRepository;
	private static StockRepository stockRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryRepository = context.getBean(CountryRepository.class);
		stockRepository = context.getBean(StockRepository.class);

		testGetAllCountries();
		testCharSearch();
		testSearch();

		testGetAllStocks();
		testGetStockByCode();
		testGetStockByCodeAndDateRange();
	}

	// Country-related test methods
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findAll();
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("End");
	}

	private static void testSearch() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("End");
	}

	private static void testCharSearch() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc("z");
		LOGGER.debug("Countries: {}", countries);
		LOGGER.info("End");
	}

	// Stock-related test methods
	private static void testGetAllStocks() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findAll();
		LOGGER.debug("Stocks: {}", stocks);
		LOGGER.info("End");
	}

	private static void testGetStockByCode() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findByCode("FB");
		LOGGER.debug("FB Stocks: {}", stocks);
		LOGGER.info("End");
	}

	private static void testGetStockByCodeAndDateRange() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findByCodeAndDateBetween(
			"FB",
			LocalDate.of(2019, 9, 10),
			LocalDate.of(2019, 9, 20)
		);
		LOGGER.debug("FB Stocks in date range: {}", stocks);
		LOGGER.info("End");
	}
}
