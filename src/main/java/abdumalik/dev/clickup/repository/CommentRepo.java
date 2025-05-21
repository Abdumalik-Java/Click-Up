package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {
}