package me.huseinnashr.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.huseinnashr.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

  @GetMapping("/new")
  public String displayProjectForm(Model model) {

    Project project = new Project();

    model.addAttribute("project", project);

    return "new-project";
  }
}