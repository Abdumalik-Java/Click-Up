package abdumalik.dev.clickup.model;

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
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String initialLetter;
    @Column(nullable = false)
    private String accessType;
    @Column(nullable = false)
    private Long avatarId;

    @ManyToMany
    private List<Workspace> workspaceId;
    @OneToOne
    private Icon iconId;
    @OneToOne
    private User ownerId;

}