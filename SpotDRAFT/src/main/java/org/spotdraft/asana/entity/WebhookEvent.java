package org.spotdraft.asana.entity;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
public class WebhookEvent {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String eventType;

    private LocalDateTime eventTimestamp;

    // Getters and setters
    // Constructors
    // Other fields and methods as needed
}

