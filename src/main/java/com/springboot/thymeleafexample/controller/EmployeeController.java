package com.springboot.thymeleafexample.controller;

import com.springboot.thymeleafexample.entity.Employee;
import com.springboot.thymeleafexample.service.EmployeeService;
import com.springboot.thymeleafexample.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String vierHomePage(Model model) {
        model.addAttribute("allemplist" , employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee (Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee" , employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id ,
                             Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee" , employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        employeeService.deleteViaId(id);
        //Hello 2 3
        return "redirect:/";
    }
}
