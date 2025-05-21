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
public class CategoryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;

    @OneToOne
    private Category categoryId;
    @OneToOne
    private User userId;

    @Enumerated
    private Permission permission;

}