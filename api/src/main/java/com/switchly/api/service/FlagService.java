
package com.switchly.api.service;

import com.switchly.api.model.Flag;
import com.switchly.api.repository.FlagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {

    private final FlagRepository flagRepository;

    public FlagService(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    public Flag create(UUID projectId, String key) {
        Flag flag = new Flag(UUID.randomUUID(), projectId, key, false);
        return flagRepository.save(flag);
    }

    public List<Flag> findByProjectId(UUID projectId) {
        return flagRepository.findByProjectId(projectId);
    }

    public Flag findById(UUID flagId) {
        return flagRepository.findById(flagId).orElseThrow();
    }

    public Flag updateState(UUID flagId, boolean enabled) {
        Flag existingFlag = findById(flagId);

        Flag updatedFlag = new Flag(
                existingFlag.id(),
                existingFlag.projectId(),
                existingFlag.key(),
                enabled
        );

        return flagRepository.save(updatedFlag);
    }
}
