package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.TimeTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeTrackerRepo extends JpaRepository<TimeTracker, UUID> {
}