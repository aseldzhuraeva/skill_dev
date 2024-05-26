package skill_dev.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity{
    String username;
    String password;
    Role role;
    String firstName;
    String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Submission> submissions;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Ranking ranking;

}
