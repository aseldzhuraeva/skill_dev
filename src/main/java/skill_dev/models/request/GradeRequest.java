package skill_dev.models.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GradeRequest {
    Long submissionId;
    Double score;
    String feedback;
}
