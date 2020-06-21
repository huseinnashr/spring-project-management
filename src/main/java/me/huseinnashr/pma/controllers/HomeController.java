package me.huseinnashr.pma.controllers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dto.ChartData;
import me.huseinnashr.pma.dto.EmployeeProject;
import me.huseinnashr.pma.entities.Project;
import me.huseinnashr.pma.services.EmployeeService;
import me.huseinnashr.pma.services.ProjectService;

@Controller
@RequestMapping("")
public class HomeController {

  @Value("${version}")
  private String ver;

  @Autowired
  ProjectService proService;

  @Autowired
  EmployeeService empService;

  @GetMapping
  public String displayHome(Model model) throws JsonProcessingException {

    model.addAttribute("versionNumber", ver);

    List<Project> projects = proService.getAll();
    model.addAttribute("projects", projects);

    List<ChartData> projectData = proService.getProjectStatus();
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(projectData);

    model.addAttribute("projectStatusCount", jsonString);

    List<EmployeeProject> employeesProjectCount = empService.employeeProject();
    model.addAttribute("employeesProjectCount", employeesProjectCount);

    return "main/home";
  }

}