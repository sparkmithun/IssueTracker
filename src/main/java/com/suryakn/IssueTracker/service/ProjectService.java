package com.mithunm.IssueTracker.service;

import com.mithunm.IssueTracker.dto.ProjectDto;
import com.mithunm.IssueTracker.dto.ProjectRequest;
import com.mithunm.IssueTracker.entity.Project;
import com.mithunm.IssueTracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            projectDtoList.add(new ProjectDto(project.getId(), project.getName()));
        }
        return ResponseEntity.ok(projectDtoList);
    }

    public ResponseEntity<Project> createProject(ProjectRequest project) {
        return ResponseEntity.ok(projectRepository.save(new Project(project.getName())));
    }

    public ResponseEntity<ProjectDto> getProject(Long pid) {
        return ResponseEntity.ok(new ProjectDto(projectRepository.findById(pid).orElseThrow()));
    }

    public void deleteProject(Long pid) {
        projectRepository.deleteById(pid);
    }
}
