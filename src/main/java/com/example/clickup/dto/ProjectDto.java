package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private String name;
    private String accessType;
    private String archived;
    private String color;
    private UUID spaceId;

}