package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskHistoryRepo extends JpaRepository<TaskHistory, UUID> {
}