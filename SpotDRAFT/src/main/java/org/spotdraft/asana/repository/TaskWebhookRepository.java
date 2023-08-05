package org.spotdraft.asana.repository;

import org.spotdraft.asana.model.TaskWebhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskWebhookRepository extends JpaRepository<TaskWebhook, Long> {
    // Add any custom query methods if needed
}
