package abdumalik.dev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceRoleDto {

    private String name;
    private String extendsRoleName;
    private UUID workspaceId;

}