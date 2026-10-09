package com.switchly.api.controller;

import com.switchly.api.model.Project;
import com.switchly.api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/api/v1/orgs/{orgId}/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(
            @PathVariable UUID orgId,
            @RequestBody CreateProjectRequest request) {
        return projectService.create(orgId, request.name());
    }

    @GetMapping("/api/v1/orgs/{orgId}/projects")
    public List<Project> findByOrgId(@PathVariable UUID orgId) {
        return projectService.findByOrgId(orgId);
    }

    @GetMapping("/api/v1/projects/{projectId}")
    public Project findById(@PathVariable UUID projectId) {
        return projectService.findById(projectId);
    }

    public record CreateProjectRequest(String name) {
    }
}
