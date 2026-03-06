package com.skyllx.ems.controller;

import com.skyllx.ems.model.Employee;
import com.skyllx.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        Optional<Employee> existingEmployee = service.getEmployeeById(id);
        if (existingEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        employee.setId(id);
        service.updateEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        Optional<Employee> existingEmployee = service.getEmployeeById(id);
        if (existingEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
