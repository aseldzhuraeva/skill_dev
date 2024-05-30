package skill_dev.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import skill_dev.models.entities.Task;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskExtendedDTO {
    public Task task;
    public Boolean locked;
}
