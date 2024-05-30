package skill_dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skill_dev.models.entities.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    boolean existsByTaskIdAndUserIdAndOk(Long taskId, Long userId, Boolean ok);
}
