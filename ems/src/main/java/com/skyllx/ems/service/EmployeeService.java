package com.skyllx.ems.service;

import com.skyllx.ems.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
