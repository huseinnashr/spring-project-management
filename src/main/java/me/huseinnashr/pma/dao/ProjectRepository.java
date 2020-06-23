package me.huseinnashr.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import me.huseinnashr.pma.dto.ChartData;
import me.huseinnashr.pma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
  @Override
  public List<Project> findAll();

  @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
  public List<ChartData> getProjectStatus();
}