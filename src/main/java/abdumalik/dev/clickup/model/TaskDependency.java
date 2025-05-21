package abdumalik.dev.clickup.model;

import abdumalik.dev.clickup.model.entity.DependencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDependency {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Integer dependencyTaskId;

    @OneToOne
    private Task taskId;

    @Enumerated
    private DependencyType dependencyType;

}