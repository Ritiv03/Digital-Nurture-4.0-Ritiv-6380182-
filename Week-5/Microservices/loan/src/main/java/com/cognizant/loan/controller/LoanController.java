package com.cognizant.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    Loan loan;

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable int number){
        loan.setNumber("H00987987972342");
        loan.setType("car");
        loan.setLoan(400000);
        loan.setEmi(3258);
        loan.setTenure(18);
        return loan;
    }
}
