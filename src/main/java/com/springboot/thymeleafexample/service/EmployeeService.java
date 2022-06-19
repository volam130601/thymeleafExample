package com.springboot.thymeleafexample.service;

import com.springboot.thymeleafexample.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteViaId(long id);
}
