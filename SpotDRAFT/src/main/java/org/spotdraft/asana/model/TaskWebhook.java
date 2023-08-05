package org.spotdraft.asana.model;


import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "task_webhooks")
@Data
public class TaskWebhook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String event;
    private String resourceId;
    private String resourceType;
    private Instant createdAt;


    public TaskWebhook() {
    }

    public TaskWebhook(String event, String resourceId, String resourceType, Instant createdAt) {
        this.event = event;
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.createdAt = createdAt;
    }

    // toString(), equals(), hashCode() (Omitted for brevity)
}

