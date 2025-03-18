package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {

    private String name;
    private String color;
    private String initialLetter;
    private String accessType;
    private Long avatarId;

    private UUID workspaceId;
    private UUID userId;
    private UUID iconId;

}