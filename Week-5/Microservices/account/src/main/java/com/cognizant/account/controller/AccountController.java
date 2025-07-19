package com.cognizant.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;


@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    Account acc;
    @GetMapping("/{number}")
    public Account getMethodName(@PathVariable int number) {
        acc.setNumber("00987987973432");
        acc.setType("savings");
        acc.setBalance(234343);
        return acc;
    }
    
}
