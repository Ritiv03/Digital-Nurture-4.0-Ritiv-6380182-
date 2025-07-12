package com.cognizant.springrest.dao;

import java.util.List;
import com.cognizant.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class EmployeeDao {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
