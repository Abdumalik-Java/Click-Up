package abdumalik.dev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private String name;
    private String color;
    private UUID spaceId;
    private UUID projectId;
    private UUID categoryId;

}