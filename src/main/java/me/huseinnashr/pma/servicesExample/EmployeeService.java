package me.huseinnashr.pma.servicesExample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  // // Field Injection
  // @Qualifier("staffRepositoryImpl2")
  // @Autowired
  IStaffRepository empRepo;

  // Constructor Injection
  public EmployeeService(@Qualifier("staffRepositoryImpl2") IStaffRepository empRepo) {
    this.empRepo = empRepo;
  }

  // // Setter Injection
  // @Qualifier("staffRepositoryImpl2")
  // @Autowired
  // public void setEmpXRepo(IStaffRepository empRepo) {
  // this.empRepo = empRepo;
  // }
}