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
@Table(name = "users")
public class User extends BaseEntity{
    String username;
    String password;
    Role role;
    String firstName;
    String lastName;
    String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Submission> submissions;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Ranking ranking;

}
