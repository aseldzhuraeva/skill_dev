package skill_dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import skill_dev.models.dto.RankingDTO;
import skill_dev.models.entities.Grade;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {


    @Query("SELECT new skill_dev.models.dto.RankingDTO(g.submission.user.id, g.submission.user.firstName, g.submission.user.lastName, SUM(g.score)) " +
            "FROM Grade g GROUP BY g.submission.user.id, g.submission.user.firstName, g.submission.user.lastName ORDER BY SUM(g.score) DESC")
    List<RankingDTO> findTotalScoresByUser();
}
