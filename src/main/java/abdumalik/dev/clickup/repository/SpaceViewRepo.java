package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.SpaceView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceViewRepo extends JpaRepository<SpaceView, UUID> {
}