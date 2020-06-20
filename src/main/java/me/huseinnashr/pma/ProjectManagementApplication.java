package me.huseinnashr.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.springExample.Car;
import me.huseinnashr.pma.springExample.Doors;
import me.huseinnashr.pma.springExample.Engine;
import me.huseinnashr.pma.springExample.Tires;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository proRepo;

	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Car(e, d, t);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
