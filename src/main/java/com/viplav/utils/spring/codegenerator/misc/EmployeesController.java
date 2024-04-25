package com.viplav.utils.spring.codegenerator.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @CrossOrigin
    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeesRepository.save(employee);
    }

    // Add more methods as needed
}
