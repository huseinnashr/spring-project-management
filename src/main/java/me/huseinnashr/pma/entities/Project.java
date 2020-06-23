package me.huseinnashr.pma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
  private long projectId;
  @NotBlank(message = "Name cannot be empty")
  private String name;
  @NotBlank(message = "Stage cannot be empty")
  private String stage;
  @NotBlank(message = "Description cannot be empty")
  private String description;

  // TODO: Fix String conversion to Date error for NotNull check
  @NotNull(message = "Start date cannot be empty")
  private Date startDate;

  @NotNull(message = "End date cannot be empty")
  private Date endDate;

  @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
      CascadeType.PERSIST }, fetch = FetchType.LAZY)
  @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
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

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee employee) {
    if (employees == null) {
      employees = new ArrayList<>();
    }
    employees.add(employee);
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}