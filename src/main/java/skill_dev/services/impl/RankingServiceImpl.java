package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skill_dev.models.dto.RankingDTO;
import skill_dev.models.entities.Ranking;
import skill_dev.models.entities.User;
import skill_dev.repositories.RankingRepository;
import skill_dev.services.RankingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;

    @Override
    public void addUserToRankingSystem(User user, Float points) {
        Ranking ranking;
        if (!isUserInRankingSystem(user)){
            ranking = Ranking.builder()
                    .user(user)
                    .totalPoints(points)
                    .build();
        }
        else {
            ranking = user.getRanking();
            ranking.setTotalPoints(ranking.getTotalPoints() + points);
        }
        rankingRepository.save(ranking);
    }

    private boolean isUserInRankingSystem(User user) {
        return rankingRepository.existsByUserId(user.getId());
    }

    @Override
    public List<RankingDTO> getRankingList() {
        List<Ranking> rankingList = rankingRepository.findAllByOrderByTotalPointsDesc();
        return rankingList.stream().map(this::toDto).collect(Collectors.toList());
    }

    private RankingDTO toDto(Ranking ranking){
        User user = ranking.getUser();
        return new RankingDTO(
                user.getFirstName(),
                user.getLastName(),
                ranking.getTotalPoints()
        );
    }
}
