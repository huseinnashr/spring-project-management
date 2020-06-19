package me.huseinnashr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.entities.Employee;
import me.huseinnashr.pma.entities.Project;

@Controller
@RequestMapping("")
public class HomeController {

  @Autowired
  ProjectRepository proRepo;

  @Autowired
  EmployeeRepository empRepo;

  @GetMapping
  public String displayHome(Model model) {
    List<Project> projects = proRepo.findAll();
    model.addAttribute("projects", projects);

    List<Employee> employees = empRepo.findAll();
    model.addAttribute("employees", employees);

    return "main/home";
  }

}