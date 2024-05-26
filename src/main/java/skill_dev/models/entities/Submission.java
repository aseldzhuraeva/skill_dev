package skill_dev.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Submission extends BaseEntity{
    String content;
    LocalDateTime submissionDate;
    @ManyToOne
    User user;
    @ManyToOne
    Task task;
}
