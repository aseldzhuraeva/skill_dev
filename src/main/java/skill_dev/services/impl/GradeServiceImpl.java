package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skill_dev.models.entities.Grade;
import skill_dev.models.entities.Submission;
import skill_dev.models.request.GradeRequest;
import skill_dev.repositories.GradeRepository;
import skill_dev.services.GradeService;
import skill_dev.services.RankingService;
import skill_dev.services.SubmissionService;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final SubmissionService submissionService;
    private final RankingService rankingService;

    @Override
    public void estimate(GradeRequest request) {
        Submission submission = submissionService.getSubmissionById(request.getSubmissionId());

        if (request.getScore() <= submission.getTask().getMax_points() ){
            Grade grade = Grade.builder()
                    .score(request.getScore())
                    .feedback(request.getFeedback() != null ? request.getFeedback() : "")
                    .submission(submission)
                    .build();

            gradeRepository.save(grade);

            rankingService.addUserToRankingSystem(submission.getUser(), grade.getScore());
        }
    }
}
