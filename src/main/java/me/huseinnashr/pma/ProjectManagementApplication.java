package me.huseinnashr.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.huseinnashr.pma.dao.EmployeeRepository;
import me.huseinnashr.pma.dao.ProjectRepository;

@SpringBootApplication(scanBasePackages = { "me.huseinnashr.pma", "me.huseinnashr.utils" })
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository proRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
