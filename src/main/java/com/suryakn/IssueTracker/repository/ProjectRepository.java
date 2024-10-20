package com.mithunm.IssueTracker.repository;

import com.mithunm.IssueTracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
