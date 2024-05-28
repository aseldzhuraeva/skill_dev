package skill_dev.services;

import skill_dev.models.entities.User;
import skill_dev.models.request.UserCreateRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void register(UserCreateRequest request);
    List<User> getAllUsers();
    User getUserById(Long id);
    Optional<User> getUserByUsername(String username);
}
