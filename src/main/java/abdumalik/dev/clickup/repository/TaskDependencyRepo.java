package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskDependencyRepo extends JpaRepository<TaskDependency, UUID> {
}