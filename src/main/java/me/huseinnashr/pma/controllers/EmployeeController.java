package me.huseinnashr.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.entities.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  EmployeeRepository empRepo;

  @GetMapping(value = "/new")
  public String displayEmployeeForm(Model model) {

    Employee employee = new Employee();

    model.addAttribute("employee", employee);

    return "employees/new-employee";
  }

  @PostMapping(value = "/save")
  public String createEmployee(Employee employee, Model model) {
    empRepo.save(employee);

    return "redirect:./new";
  }

}