package com.switchly.api.model;

import java.util.UUID;

public record Flag(
        UUID id,
        UUID projectId,
        String key,
        boolean enabled
) {
}
