package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskUserRepo extends JpaRepository<TaskUser, UUID> {
}