package com.example.clickup.model;

import com.example.clickup.model.entity.Type;
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
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;

    @OneToMany
    private List<Space> spaceId;
    @OneToOne
    private Project projectId;
    @OneToOne
    private Category categoryId;

    @Enumerated
    private Type type;

}