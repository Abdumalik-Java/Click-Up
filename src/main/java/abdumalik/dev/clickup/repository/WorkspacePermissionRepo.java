package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspacePermissionRepo extends JpaRepository<WorkspacePermission, UUID> {
}