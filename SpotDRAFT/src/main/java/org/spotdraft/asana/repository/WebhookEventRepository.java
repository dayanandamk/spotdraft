package org.spotdraft.asana.repository;

import org.spotdraft.asana.entity.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookEventRepository extends JpaRepository<WebhookEvent, Long> {
    // Custom query methods can be added here if needed
}
