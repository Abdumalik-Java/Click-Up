package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String name;
    private String description;
    private Integer parentTaskId;
    private UUID statusId;
    private UUID categoryId;
    private UUID priorityId;

}