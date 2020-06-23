package me.huseinnashr.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.huseinnashr.pma.dao.ProjectRepository;
import me.huseinnashr.pma.dto.ChartData;
import me.huseinnashr.pma.dto.TimeChartData;
import me.huseinnashr.pma.entities.Project;

@Service
public class ProjectService {
  @Autowired
  ProjectRepository proRepo;

  public Project save(Project project) {
    return proRepo.save(project);
  }

  public List<Project> getAll() {
    return proRepo.findAll();
  }

  public List<ChartData> getProjectStatus() {
    return proRepo.getProjectStatus();
  }

  public List<TimeChartData> getTimeData() {
    return proRepo.getTimeData();
  }
}