package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.TaskAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskAttachmentRepo extends JpaRepository<TaskAttachment, UUID> {
}