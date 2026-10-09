package com.switchly.api.service;

import com.switchly.api.model.Project;
import com.switchly.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(UUID orgId, String name) {
        Project project = new Project(UUID.randomUUID(), orgId, name);
        return projectRepository.save(project);
    }

    public List<Project> findByOrgId(UUID orgId) {
        return projectRepository.findByOrgId(orgId);
    }

    public Project findById(UUID projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow();
    }
}