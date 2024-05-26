package skill_dev.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RankingDTO {
    String userFirstName;
    String userLastName;
    Float totalScore;
}
