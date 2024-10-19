package com.viplav.utils.spring.codegenerator.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @CrossOrigin
    @GetMapping("/findbyfname")
    public List<Employees> getAllEmployeesWithMatchingName(String fname) {
        return employeesRepository.findAll().stream().filter(e -> e.getFirstName().contains(fname)).collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/findbyid/{id}")
    public Optional<Employees> getOneEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeesRepository.save(employee);
    }

    // Add more methods as needed
}
