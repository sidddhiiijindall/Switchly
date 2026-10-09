package com.switchly.api.service;

import com.switchly.api.model.Organization;
import com.switchly.api.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(String name) {
        Organization organization = new Organization(UUID.randomUUID(), name);
        return organizationRepository.save(organization);
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Organization findById(UUID id) {
        return organizationRepository.findById(id)
                .orElseThrow();
    }
}