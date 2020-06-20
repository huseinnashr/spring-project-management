package me.huseinnashr.pma.services;

import org.springframework.stereotype.Service;

import me.huseinnashr.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {

  // // Field Injection
  // @Autowired
  EmployeeRepository empRepo;

  // Constructor Injection
  public EmployeeService(EmployeeRepository empRepo) {
    this.empRepo = empRepo;
  }

  // // Setter Injection
  // @Autowired
  // public void setEmpXRepo(EmployeeRepository empRepo) {
  // this.empRepo = empRepo;
  // }
}