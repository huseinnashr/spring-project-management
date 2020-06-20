package me.huseinnashr.pma.controllers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.dto.ChartData;
import me.huseinnashr.pma.dto.EmployeeProject;
import me.huseinnashr.pma.entities.Project;

@Controller
@RequestMapping("")
public class HomeController {

  @Autowired
  ProjectRepository proRepo;

  @Autowired
  EmployeeRepository empRepo;

  @GetMapping
  public String displayHome(Model model) throws JsonProcessingException {
    List<Project> projects = proRepo.findAll();
    model.addAttribute("projects", projects);

    List<ChartData> projectData = proRepo.getProjectStatus();
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(projectData);

    model.addAttribute("projectStatusCount", jsonString);

    List<EmployeeProject> employeesProjectCount = empRepo.employeeProject();
    model.addAttribute("employeesProjectCount", employeesProjectCount);

    return "main/home";
  }

}