package abdumalik.dev.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspaceUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Workspace workspaceId;
    @ManyToOne
    private User userId;
    @ManyToOne
    private WorkspaceRole workspaceRoleId;

    @CreatedDate
    private LocalDateTime dateInvited;
    @CreationTimestamp
    private LocalDateTime dateJoined;

}