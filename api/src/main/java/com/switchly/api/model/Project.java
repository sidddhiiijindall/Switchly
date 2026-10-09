package com.switchly.api.model;

import java.util.UUID;

public record Project(
        UUID id,
        UUID orgId,
        String name
) {
}