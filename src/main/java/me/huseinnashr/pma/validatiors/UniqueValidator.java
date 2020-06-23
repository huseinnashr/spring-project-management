package me.huseinnashr.pma.validatiors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

  @Autowired
  EmployeeRepository empRepo;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Employee emp = empRepo.findByEmail(value);

    return emp == null;
  }

}
