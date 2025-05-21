package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.SpaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpaceUserRepo extends JpaRepository<SpaceUser, UUID> {
}