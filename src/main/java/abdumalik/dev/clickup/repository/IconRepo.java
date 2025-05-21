package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IconRepo extends JpaRepository<Icon, UUID> {
}