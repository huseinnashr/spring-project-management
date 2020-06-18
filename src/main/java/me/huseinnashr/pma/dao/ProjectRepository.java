package me.huseinnashr.pma.dao;

import org.springframework.data.repository.CrudRepository;

import me.huseinnashr.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}