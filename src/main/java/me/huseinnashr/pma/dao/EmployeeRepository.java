package me.huseinnashr.pma.dao;

import org.springframework.data.repository.CrudRepository;

import me.huseinnashr.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}