package skill_dev.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RankingDTO {

    Long userId;
    String userFirstName;
    String userLastName;
    Double totalScore;
}
