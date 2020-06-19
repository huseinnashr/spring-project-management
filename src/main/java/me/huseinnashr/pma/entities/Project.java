package me.huseinnashr.pma.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long projectId;
  private String name;
  private String stage;
  private String description;

  @OneToMany(mappedBy = "project")
  private List<Employee> employees;

  public Project() {
  }

  public Project(String name, String stage, String description) {
    this.setName(name);
    this.setStage(stage);
    this.setDescription(description);
  }

  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Employee> getEmployees() {
    return employees;
  }
}