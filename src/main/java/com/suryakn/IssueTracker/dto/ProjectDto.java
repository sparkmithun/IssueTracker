package com.mithunm.IssueTracker.dto;

import com.mithunm.IssueTracker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String name;

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
    }
}
