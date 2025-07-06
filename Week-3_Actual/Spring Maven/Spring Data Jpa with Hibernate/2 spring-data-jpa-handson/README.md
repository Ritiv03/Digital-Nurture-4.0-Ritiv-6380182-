
---

# Spring Data JPA – ORM Learn Project

## Overview

This project demonstrates the use of Spring Data JPA with Query Methods and Object Relational Mapping (ORM) using annotations such as @ManyToOne, @OneToMany, @JoinColumn, @JoinTable, etc.

It is structured into two major hands-on exercises:

* Exercise 1: Working with the country table
* Exercise 2: Working with the stock table (with stock data for Facebook, Google, and Netflix)

Note: This project contains working solutions and outputs for Exercise 1 and Exercise 2. Further exercises could not be completed as the required materials and instructions were not provided.

## Technologies Used

* Java 17+
* Spring Boot 3.x
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Project Structure

src/
└── main/
├── java/com/cognizant/orm\_learn/
│    ├── model/             → Contains Country.java, Stock.java
│    ├── repository/        → Contains CountryRepository.java, StockRepository.java
│    ├── service/           → Contains CountryService.java
│    └── OrmLearnApplication.java
└── resources/
└── application.properties

## Exercise 1 – Country Table

Query Methods Implemented:

* Search for countries containing a specific text (e.g., "ou")
* Retrieve countries in ascending order of name
* Retrieve countries starting with a particular alphabet (e.g., "Z")

Tested Methods in OrmLearnApplication:

* testGetAllCountries()
* testSearch()
* testCharSearch()

## Exercise 2 – Stock Table

Table Creation:
CREATE TABLE IF NOT EXISTS stock (
st\_id INT NOT NULL AUTO\_INCREMENT,
st\_code VARCHAR(10),
st\_date DATE,
st\_open NUMERIC(10,2),
st\_close NUMERIC(10,2),
st\_volume NUMERIC,
PRIMARY KEY (st\_id)
);

Sample Data:

* The data was sourced from stock-data.csv containing public historical data from Yahoo Finance.
* A formula in Excel was used to convert this into insert statements and executed in MySQL.

Query Methods Implemented:

* Get all stock entries for Facebook for the month of September 2019
* Get all Google stock entries where closing price was greater than 1250
* Retrieve top 3 dates with the highest trading volume
* Find 3 dates with the lowest closing price for Netflix

Tested Methods in OrmLearnApplication:

* testGetStockByCodeAndMonth()
* testGoogleStockPriceAboveThreshold()
* testTop3HighestVolumeStocks()
* testLowest3NetflixStocks()

## End of Document
