package abdumalik.dev.clickup.model;

import abdumalik.dev.clickup.model.entity.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    private List<Project> projectId;
    @OneToOne
    private User userId;

    @Enumerated
    private Permission permission;

}