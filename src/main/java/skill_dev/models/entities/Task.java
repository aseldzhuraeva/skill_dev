package skill_dev.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task extends BaseEntity{
    String title;
    String description;
    Float maxPoints;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    List<Submission> submissions;
}
