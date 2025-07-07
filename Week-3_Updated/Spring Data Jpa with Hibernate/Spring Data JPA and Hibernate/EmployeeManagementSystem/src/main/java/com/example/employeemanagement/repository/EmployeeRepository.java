package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmailCustom(String email);

    Page<Employee> findAll(Pageable pageable);
}
