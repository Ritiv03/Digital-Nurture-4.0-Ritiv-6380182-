package com.cognizant.springrest.dao;

import java.util.List;
import com.cognizant.springrest.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

    @Autowired
    private List<Department> departmentList;

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
