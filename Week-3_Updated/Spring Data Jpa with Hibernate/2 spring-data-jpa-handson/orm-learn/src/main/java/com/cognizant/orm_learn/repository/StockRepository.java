package com.cognizant.orm_learn.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Example: Find stocks by company code
    List<Stock> findByCode(String code);

    // Example: Find stocks by code and date range
    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    // Example: Find top 5 recent entries for a stock
    List<Stock> findTop5ByCodeOrderByDateDesc(String code);
}
