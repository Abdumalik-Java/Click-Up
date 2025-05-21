package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.SpaceClickApps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceClickAppsRepo extends JpaRepository<SpaceClickApps, UUID> {
}