package me.huseinnashr.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.huseinnashr.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
  @Override
  public List<Project> findAll();
}