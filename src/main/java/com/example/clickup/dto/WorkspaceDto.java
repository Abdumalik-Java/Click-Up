package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {

    private String name;
    private String color;
    private UUID ownerId;
    private String initialLetter;
    private Long avatarId;

}