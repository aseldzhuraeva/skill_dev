package skill_dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skill_dev.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
