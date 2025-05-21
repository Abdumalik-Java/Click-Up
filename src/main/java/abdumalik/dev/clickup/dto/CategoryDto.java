package abdumalik.dev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String name;
    private String accessType;
    private String archived;
    private String color;
    private UUID projectId;

}