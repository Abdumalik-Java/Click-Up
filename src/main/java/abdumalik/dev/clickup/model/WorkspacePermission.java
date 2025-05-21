package abdumalik.dev.clickup.model;

import abdumalik.dev.clickup.model.entity.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspacePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private WorkspaceRole workspaceRoleId;

    @Enumerated
    private Permission permission;

}