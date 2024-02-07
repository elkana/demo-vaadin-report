package com.example.demovaadinreport.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demovaadinreport.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
