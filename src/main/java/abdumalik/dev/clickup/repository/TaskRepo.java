package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
    Optional<Task> findByName(String name);
    boolean existsByName(String name);
}