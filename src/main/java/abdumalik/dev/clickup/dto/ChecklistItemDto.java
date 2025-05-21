package abdumalik.dev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistItemDto {

    private String name;
    private Boolean resolved;
    private UUID checklistId;
    private UUID assignedUserId;

}