package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpaceRepo extends JpaRepository<Space, UUID> {
    Optional<Space> findByName(String name);
}