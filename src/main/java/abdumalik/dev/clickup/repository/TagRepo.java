package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepo extends JpaRepository<Tag, UUID> {
}