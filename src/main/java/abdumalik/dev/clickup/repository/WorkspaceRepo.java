package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkspaceRepo extends JpaRepository<Workspace, UUID> {
    Optional<Workspace> findByName(String name);
}