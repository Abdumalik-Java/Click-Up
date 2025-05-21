package abdumalik.dev.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer parentTaskId;

    @OneToOne
    private Status statusId;
    @OneToOne
    private Category categoryId;
    @OneToOne
    private Priority priorityId;

    @CreatedDate
    private LocalDateTime startedTime = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime startedTimeHas = LocalDateTime.now();
    @CreationTimestamp
    private LocalDateTime dueTime = LocalDateTime.now();
    @CreationTimestamp
    private LocalDateTime dueTimeHas = LocalDateTime.now();
    @Column(nullable = false)
    private Long estimatedTime;
    @LastModifiedDate
    private LocalDateTime activedTime = LocalDateTime.now();

}