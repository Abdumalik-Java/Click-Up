package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepo extends JpaRepository<Attachment, UUID> {
}