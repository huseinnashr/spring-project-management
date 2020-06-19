package me.huseinnashr.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.huseinnashr.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
  @Override
  public List<Employee> findAll();
}