package org.spotdraft.asana.repository;

import org.spotdraft.asana.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Add custom queries or methods specific to the Task entity if needed
}
