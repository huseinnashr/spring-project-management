package me.huseinnashr.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.entities.Project;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  ProjectRepository proRepo;

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

    return "projects/new-project";
  }

  @PostMapping(value = "/save")
  public String createProject(Project project, Model model) {
    proRepo.save(project);

    return "redirect:./new";
  }

}