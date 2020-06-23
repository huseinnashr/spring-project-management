package me.huseinnashr.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  public String createEmployee(Model model, @Valid Employee employee, Errors errors) {

    if (errors.hasErrors())
      return "employees/new-employee";

    empService.save(employee);

    return "redirect:./new";
  }

  @GetMapping("/update")
  public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
    Employee emp = empService.findByEmployeeId(id);
    model.addAttribute("employee", emp);
    return "employees/new-employee";
  }

  @GetMapping("/delete")
  public String deleteEmployee(@RequestParam("id") long id, Model model) {
    Employee emp = empService.findByEmployeeId(id);
    empService.delete(emp);
    return "redirect:/employees";
  }
}