package skill_dev.models.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String password2;
}
