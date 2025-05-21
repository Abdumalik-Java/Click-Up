package abdumalik.dev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceUserDto {

    private UUID workspaceId;
    private UUID userId;
    private UUID workspaceRoleId;

}