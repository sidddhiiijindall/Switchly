package com.switchly.api.repository;

import com.switchly.api.model.Organization;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InMemoryOrganizationRepository implements OrganizationRepository {

    private final Map<UUID, Organization> organizations = new HashMap<>();

    @Override
    public Organization save(Organization organization) {
        organizations.put(organization.getId(), organization);
        return organization;
    }

    @Override
    public Optional<Organization> findById(UUID id) {
        return Optional.ofNullable(organizations.get(id));
    }

    @Override
    public List<Organization> findAll() {
        return new ArrayList<>(organizations.values());
    }
}

