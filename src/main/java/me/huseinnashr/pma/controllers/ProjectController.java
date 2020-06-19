package me.huseinnashr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.entities.Employee;
import me.huseinnashr.pma.entities.Project;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  ProjectRepository proRepo;

  @Autowired
  EmployeeRepository empRepo;

  @GetMapping
  public String displayprojects(Model model) {
    List<Project> projects = proRepo.findAll();
    model.addAttribute("projects", projects);

    return "projects/list-projects";
  }

  @GetMapping("/new")
  public String displayProjectForm(Model model) {

    Project project = new Project();
    model.addAttribute("project", project);

    List<Employee> employees = empRepo.findAll();
    model.addAttribute("allEmployees", employees);

    return "projects/new-project";
  }

  @PostMapping(value = "/save")
  public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
    proRepo.save(project);

    Iterable<Employee> chooseEmployees = empRepo.findAllById(employees);

    for (Employee employee : chooseEmployees) {
      employee.setProject(project);
      empRepo.save(employee);
    }

    return "redirect:./new";
  }

}