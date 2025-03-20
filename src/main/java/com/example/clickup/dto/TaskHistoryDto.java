package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskHistoryDto {

    private String changeFieldName;
    private String before;
    private String after;
    private String data;
    private UUID taskId;

}