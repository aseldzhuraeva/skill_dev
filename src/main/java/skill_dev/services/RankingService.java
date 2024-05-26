package skill_dev.services;

import skill_dev.models.dto.RankingDTO;
import skill_dev.models.entities.User;

import java.util.List;

public interface RankingService {
    void addUserToRankingSystem(User user, Float points);
    List<RankingDTO> getRankingList();
}
