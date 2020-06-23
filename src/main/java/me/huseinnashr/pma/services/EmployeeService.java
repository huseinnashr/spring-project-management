package me.huseinnashr.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dto.EmployeeProject;
import me.huseinnashr.pma.entities.Employee;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository empRepo;

  public Employee save(Employee employee) {
    return empRepo.save(employee);
  }

  public List<Employee> getAll() {
    return empRepo.findAll();
  }

  public List<EmployeeProject> employeeProject() {
    return empRepo.employeeProject();
  }

  public Employee findByEmployeeId(long theId) {
    return empRepo.findById(theId).get();
  }

  public void delete(Employee theEmp) {
    empRepo.delete(theEmp);
  }
}