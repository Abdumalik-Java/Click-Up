package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriorityRepo extends JpaRepository<Priority, UUID> {
}