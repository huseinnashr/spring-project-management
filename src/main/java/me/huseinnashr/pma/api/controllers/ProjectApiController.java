package me.huseinnashr.pma.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.entities.Project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// TODO: Controller should automatically find existing employees when passing array of employee id
@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {

  @Autowired
  ProjectRepository proRepo;

  @GetMapping
  public Iterable<Project> getProjects() {
    return proRepo.findAll();
  }

  @GetMapping("/{id}")
  public Project getProjectById(@PathVariable("id") Long id) {
    return proRepo.findById(id).get();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Project create(@RequestBody Project project) {
    return project;
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public Project update(@RequestBody Project project) {
    return proRepo.save(project);
  }

  @PatchMapping(path = "/{id}")
  public Project partialUpdate(@PathVariable("id") long id, @RequestBody Project patchProject) {
    Project emp = proRepo.findById(id).get();

    if (patchProject.getName() != null) {
      emp.setName(patchProject.getName());
    }

    if (patchProject.getStage() != null) {
      emp.setStage(patchProject.getStage());
    }

    if (patchProject.getDescription() != null) {
      emp.setDescription(patchProject.getDescription());
    }

    return proRepo.save(emp);
  }

  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    try {
      proRepo.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
    }
  }
}