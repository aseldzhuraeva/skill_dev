package skill_dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import skill_dev.models.entities.Ranking;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Ranking r WHERE r.user.id = :userId")
    boolean existsByUserId(Long userId);

    List<Ranking> findAllByOrderByTotalPointsDesc();

}
