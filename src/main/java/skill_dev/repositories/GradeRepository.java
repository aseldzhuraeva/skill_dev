package skill_dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skill_dev.models.entities.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
