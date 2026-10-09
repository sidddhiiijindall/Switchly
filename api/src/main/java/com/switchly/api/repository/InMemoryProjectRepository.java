package com.switchly.api.repository;

import com.switchly.api.model.Project;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {

    private final Map<UUID, Project> projects = new HashMap<>();

    @Override
    public Project save(Project project) {
        projects.put(project.id(), project);
        return project;
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public List<Project> findByOrgId(UUID orgId) {
        return projects.values().stream()
                .filter(project -> project.orgId().equals(orgId))
                .toList();
    }
}