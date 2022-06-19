package com.springboot.thymeleafexample.service.impl;

import com.springboot.thymeleafexample.entity.Employee;
import com.springboot.thymeleafexample.repository.EmployeeRepository;
import com.springboot.thymeleafexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id: "+ id);
        return employee;
    }

    @Override
    public void deleteViaId(long id) {
        employeeRepository.deleteById(id);
    }
}
