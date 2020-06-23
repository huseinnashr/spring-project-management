package me.huseinnashr.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dto.TimeChartData;
import me.huseinnashr.pma.entities.Employee;
import me.huseinnashr.pma.entities.Project;
import me.huseinnashr.pma.services.EmployeeService;
import me.huseinnashr.pma.services.ProjectService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  ProjectService proService;

  @Autowired
  EmployeeService empService;

  @GetMapping
  public String displayprojects(Model model) {
    List<Project> projects = proService.getAll();
    model.addAttribute("projects", projects);

    return "projects/list-projects";
  }

  @GetMapping("/new")
  public String displayProjectForm(Model model) {

    Project project = new Project();
    model.addAttribute("project", project);

    List<Employee> employees = empService.getAll();
    model.addAttribute("allEmployees", employees);

    return "projects/new-project";
  }

  @PostMapping(value = "/save")
  public String createProject(Model model, @Valid Project project, Errors errors) {
    List<Employee> employees = empService.getAll();
    model.addAttribute("allEmployees", employees);

    if (errors.hasErrors())
      return "projects/new-project";

    proService.save(project);

    return "redirect:./new";
  }

  @GetMapping("/timelines")
  public String displayProjectTimelines(Model model) throws JsonProcessingException {
    List<TimeChartData> timelineData = proService.getTimeData();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonTimelineString = objectMapper.writeValueAsString(timelineData);

    model.addAttribute("projectTimeList", jsonTimelineString);
    System.out.println(jsonTimelineString);
    return "projects/project-timelines";
  }
}