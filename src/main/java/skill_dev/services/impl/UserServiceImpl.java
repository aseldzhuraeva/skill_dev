package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skill_dev.models.entities.Role;
import skill_dev.models.entities.User;
import skill_dev.models.request.UserCreateRequest;
import skill_dev.repositories.UserRepository;
import skill_dev.services.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void register(UserCreateRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .role(Role.STUDENT)
                .build();

        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("there is not such user"));
    }


}
