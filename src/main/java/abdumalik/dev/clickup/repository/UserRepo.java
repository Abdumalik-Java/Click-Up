package abdumalik.dev.clickup.repository;

import abdumalik.dev.clickup.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    boolean existsByEmail(@Email String email);
}