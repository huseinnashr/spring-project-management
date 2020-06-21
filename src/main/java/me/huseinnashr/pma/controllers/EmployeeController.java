package me.huseinnashr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.entities.Employee;
import me.huseinnashr.pma.services.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  EmployeeService empService;

  @GetMapping
  public String displayEmployees(Model model) {
    List<Employee> employees = empService.getAll();
    model.addAttribute("employees", employees);

    return "employees/list-employees";
  }

  @GetMapping(value = "/new")
  public String displayEmployeeForm(Model model) {

    Employee employee = new Employee();

    model.addAttribute("employee", employee);

    return "employees/new-employee";
  }

  @PostMapping(value = "/save")
  public String createEmployee(Employee employee, Model model) {
    empService.save(employee);

    return "redirect:./new";
  }

}