package com.skyllx.ems.service;

import com.skyllx.ems.model.Employee;
import com.skyllx.ems.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo repo;

    @Override
    public Employee saveEmployee(Employee employee) {
        // Force create semantics for the /save endpoint.
        employee.setId(null);
        return repo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return repo.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
