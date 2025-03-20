package com.example.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAttachmentDto {

    private Boolean pinCoverImage;
    private UUID taskId;
    private UUID attachmentId;

}