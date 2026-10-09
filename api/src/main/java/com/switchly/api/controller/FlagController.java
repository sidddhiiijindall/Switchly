
package com.switchly.api.controller;

import com.switchly.api.model.Flag;
import com.switchly.api.service.FlagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping("/api/v1/projects/{projectId}/flags")
    @ResponseStatus(HttpStatus.CREATED)
    public Flag create(
            @PathVariable UUID projectId,
            @RequestBody CreateFlagRequest request) {
        return flagService.create(projectId, request.key());
    }

    @GetMapping("/api/v1/projects/{projectId}/flags")
    public List<Flag> findByProjectId(@PathVariable UUID projectId) {
        return flagService.findByProjectId(projectId);
    }

    @GetMapping("/api/v1/flags/{flagId}")
    public Flag findById(@PathVariable UUID flagId) {
        return flagService.findById(flagId);
    }

    @PutMapping("/api/v1/flags/{flagId}/state")
    public Flag updateState(
            @PathVariable UUID flagId,
            @RequestBody UpdateFlagStateRequest request) {
        return flagService.updateState(flagId, request.enabled());
    }

    public record CreateFlagRequest(String key) {}

    public record UpdateFlagStateRequest(boolean enabled) {}
}