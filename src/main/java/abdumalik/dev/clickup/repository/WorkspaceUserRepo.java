package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceUserRepo extends JpaRepository<WorkspaceUser, UUID> {
}
