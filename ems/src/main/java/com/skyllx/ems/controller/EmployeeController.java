package com.skyllx.ems.controller;

import com.skyllx.ems.model.Employee;
import com.skyllx.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ems")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@RequestParam int id){
        return service.getEmployeeById(id);
    }


}
