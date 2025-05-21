package abdumalik.dev.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String changeFieldName;
    @Column(nullable = false)
    private String before;
    @Column(nullable = false)
    private String after;
    @Column(nullable = false)
    private String data;

    @OneToOne
    private Task task;

}