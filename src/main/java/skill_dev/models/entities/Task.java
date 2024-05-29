package skill_dev.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tasks")
public class Task extends BaseEntity{
    String title;
    String description;

    String image;

    String input;

    String answer;

    Float max_points;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    List<Submission> submissions;
}
