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

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.entities.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {

  @Autowired
  EmployeeRepository empRepo;

  @GetMapping
  public Iterable<Employee> getEmployees() {
    return empRepo.findAll();
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable("id") Long id) {
    return empRepo.findById(id).get();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Employee create(@RequestBody Employee employee) {
    return empRepo.save(employee);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public Employee update(@RequestBody Employee employee) {
    return empRepo.save(employee);
  }

  @PatchMapping(path = "/{id}")
  public Employee partialUpdate(@PathVariable("id") long id, @RequestBody Employee patchEmployee) {
    Employee emp = empRepo.findById(id).get();

    if (patchEmployee.getEmail() != null) {
      emp.setEmail(patchEmployee.getEmail());
    }

    if (patchEmployee.getFirstName() != null) {
      emp.setFirstName(patchEmployee.getFirstName());
    }

    if (patchEmployee.getLastName() != null) {
      emp.setLastName(patchEmployee.getLastName());
    }

    return empRepo.save(emp);
  }

  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    try {
      empRepo.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
    }
  }
}