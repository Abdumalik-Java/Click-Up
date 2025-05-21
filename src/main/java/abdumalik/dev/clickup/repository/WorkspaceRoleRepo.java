package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.WorkspaceRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceRoleRepo extends JpaRepository<WorkspaceRole, UUID> {
}